package com.example.network;

import com.example.ExampleMod;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record MiningStrategyPayload(String strategy) implements CustomPayload {
    public static final CustomPayload.Id<MiningStrategyPayload> ID =
            new CustomPayload.Id<>(Identifier.of(ExampleMod.MOD_ID, "mining_strategy"));

    public static final PacketCodec<RegistryByteBuf, MiningStrategyPayload> CODEC =
            PacketCodec.tuple(PacketCodecs.STRING, MiningStrategyPayload::strategy, MiningStrategyPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}
