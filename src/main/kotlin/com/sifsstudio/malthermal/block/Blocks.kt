package com.sifsstudio.malthermal.block

import com.sifsstudio.malthermal.Malthermal
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Blocks {

    lateinit var IRON_TANK_BLOCK: IronTankBlock

    fun register() {
        IRON_TANK_BLOCK = Registry.register(Registry.BLOCK, Malthermal / "iron_tank", IronTankBlock)
        Registry.register(Registry.ITEM,Malthermal / "iron_tank", BlockItem(IRON_TANK_BLOCK, FabricItemSettings()))
    }

}