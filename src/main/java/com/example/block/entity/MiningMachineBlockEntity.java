package com.example.block.entity;

import com.example.BlockEntities;
import com.example.screenhandler.MiningMachineScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MiningMachineBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public MiningMachineBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ENTIDADE_BLOCO_MINERACAO, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void addItemToInventory(ItemStack itemStack) {
        // Primeiro, tenta agrupar o item nos slots existentes
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack currentStack = inventory.get(i);

            // Verifica se o item no slot atual é o mesmo tipo
            if (!currentStack.isEmpty() && ItemStack.areItemsEqual(currentStack, itemStack)) {
                int newCount = currentStack.getCount() + itemStack.getCount();
                if (newCount <= currentStack.getMaxCount()) {
                    currentStack.setCount(newCount); // Agrupa os itens
                    markDirty();
                    return; // Item agrupado, não precisa adicionar mais nada
                }
            }
        }

        // Se não conseguiu agrupar (ou seja, não encontrou nenhum item igual ou o empilhamento foi ultrapassado), adiciona o item em um slot vazio
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).isEmpty()) {
                inventory.set(i, itemStack); // Coloca o item no primeiro slot vazio
                markDirty();
                break;
            }
        }
    }

    @Override
    public Text getDisplayName() {
        return Text.of("Mining Machine Block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MiningMachineScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, inventory, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }
}
