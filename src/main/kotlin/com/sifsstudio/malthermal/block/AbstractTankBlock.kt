package com.sifsstudio.malthermal.block

import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.WorldAccess

abstract class AbstractTankBlock(settings: Settings?) : BlockWithEntity(settings) {

    init {
        defaultState = stateManager.defaultState.with(UP,false).with(DOWN, false).with(EAST, false).with(WEST, false).with(NORTH, false).with(SOUTH, false)
    }

    companion object {
        val UP: BooleanProperty = BooleanProperty.of("up")
        val DOWN: BooleanProperty = BooleanProperty.of("down")
        val EAST: BooleanProperty = BooleanProperty.of("east")
        val WEST: BooleanProperty = BooleanProperty.of("west")
        val NORTH: BooleanProperty = BooleanProperty.of("north")
        val SOUTH: BooleanProperty = BooleanProperty.of("south")
    }

    abstract val thermalConductivity: Float

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.ENTITYBLOCK_ANIMATED
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(UP, DOWN, EAST, WEST, NORTH, SOUTH)
    }

    override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
        val world = ctx?.world
        val pos = ctx?.blockPos
        val up = pos?.up()
        val down = pos?.down()
        val east = pos?.east()
        val west = pos?.west()
        val north = pos?.north()
        val south = pos?.south()
        var actualState = defaultState
        if (world?.getBlockState(up)?.block is AbstractTankBlock) {
            actualState = actualState.with(UP, true)
        }
        if (world?.getBlockState(down)?.block is AbstractTankBlock) {
            actualState =actualState.with(DOWN, true)
        }
        if (world?.getBlockState(east)?.block is AbstractTankBlock) {
            actualState =actualState.with(EAST, true)
        }
        if (world?.getBlockState(west)?.block is AbstractTankBlock) {
            actualState =actualState.with(WEST, true)
        }
        if (world?.getBlockState(north)?.block is AbstractTankBlock) {
            actualState =actualState.with(NORTH, true)
        }
        if (world?.getBlockState(south)?.block is AbstractTankBlock) {
            actualState =actualState.with(SOUTH, true)
        }
        return actualState
    }

    override fun getStateForNeighborUpdate(
        state: BlockState?,
        direction: Direction?,
        neighborState: BlockState?,
        world: WorldAccess?,
        pos: BlockPos?,
        neighborPos: BlockPos?
    ): BlockState {
        val isTank = neighborState?.block is AbstractTankBlock
        val newState: BlockState? = when (direction!!) {
            Direction.UP -> state?.with(UP, isTank)
            Direction.DOWN -> state?.with(DOWN, isTank)
            Direction.EAST -> state?.with(EAST, isTank)
            Direction.WEST -> state?.with(WEST, isTank)
            Direction.NORTH -> state?.with(NORTH, isTank)
            Direction.SOUTH -> state?.with(SOUTH, isTank)
        }
        return newState!!
    }
}