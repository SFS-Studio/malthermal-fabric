package com.sifsstudio.malthermal.client

import com.sifsstudio.malthermal.client.render.block.IronTankBlockEntityRenderer
import com.sifsstudio.malthermal.tile.BlockEntities
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry

@Environment(EnvType.CLIENT)
object MalthermalClient: ClientModInitializer {
    override fun onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.IRON_TANK, ::IronTankBlockEntityRenderer)
    }
}