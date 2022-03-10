package com.sifsstudio.malthermal.client.render.block

import com.sifsstudio.malthermal.tile.AbstractTankBlockEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.util.math.MatrixStack

abstract class AbstractTankBlockEntityRenderer<T: AbstractTankBlockEntity>(dispatcher: BlockEntityRenderDispatcher?) :
    BlockEntityRenderer<T>(dispatcher) {

    abstract fun renderHull(entity: T,
                            tickDelta: Float,
                            matrices: MatrixStack?,
                            vertexConsumers: VertexConsumerProvider?,
                            light: Int,
                            overlay: Int)

    override fun render(
        entity: T,
        tickDelta: Float,
        matrices: MatrixStack?,
        vertexConsumers: VertexConsumerProvider?,
        light: Int,
        overlay: Int
    ) {
        renderHull(entity, tickDelta, matrices, vertexConsumers, light, overlay)
    }


}