package com.example.block.entity;

import com.example.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class MiningMachineBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

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

            // Verifica se o item no slot atual é o mesmo tipo e com NBT igual
            if (!currentStack.isEmpty() && ItemStack.areItemsEqual(currentStack, itemStack)) {
                // Se o item já existe e o empilhamento não ultrapassar o limite
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
