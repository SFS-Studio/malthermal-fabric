package com.sifsstudio.malthermal.block

import com.sifsstudio.malthermal.tile.IronTankBlockEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.world.BlockView

object IronTankBlock: AbstractTankBlock(FabricBlockSettings.of(Material.METAL)) {
    override val thermalConductivity: Float = 80.0F

    override fun createBlockEntity(world: BlockView?): BlockEntity? {
        return IronTankBlockEntity()
    }
}