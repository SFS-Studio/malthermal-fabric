package com.sifsstudio.malthermal.client.render.block

import com.sifsstudio.malthermal.tile.IronTankBlockEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher
import net.minecraft.client.util.math.MatrixStack

class IronTankBlockEntityRenderer(dispatcher: BlockEntityRenderDispatcher?) :
    AbstractTankBlockEntityRenderer<IronTankBlockEntity>(dispatcher) {

    override fun renderHull(
        entity: IronTankBlockEntity,
        tickDelta: Float,
        matrices: MatrixStack?,
        vertexConsumers: VertexConsumerProvider?,
        light: Int,
        overlay: Int
    ) {
        TODO("Not yet implemented")
    }
}