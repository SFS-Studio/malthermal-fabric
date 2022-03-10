package com.sifsstudio.malthermal.tile

import com.sifsstudio.malthermal.Malthermal
import com.sifsstudio.malthermal.block.IronTankBlock
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object BlockEntities {

    lateinit var IRON_TANK: BlockEntityType<IronTankBlockEntity>

    fun register() {
        IRON_TANK = Registry.register(Registry.BLOCK_ENTITY_TYPE, Malthermal / "iron_tank", BlockEntityType.Builder.create(::IronTankBlockEntity, IronTankBlock).build(null))
    }

}