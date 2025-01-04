package com.logic_thinkering.itens;

public abstract class PrototypeItem {
    protected StrategyRegister strategy;

    public abstract PrototypeItem clone();
    public abstract void register(String id);
    public abstract void updateMaterial(String material);
}
