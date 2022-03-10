package com.sifsstudio.malthermal.tile

import com.sifsstudio.malthermal.Malthermal
import com.sifsstudio.malthermal.api.ThermalConstants
import com.sifsstudio.malthermal.api.tile.HasThermalProperties
import com.sifsstudio.malthermal.api.tile.WorkingFluid
import com.sifsstudio.malthermal.block.AbstractTankBlock
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.Tickable
import net.minecraft.util.math.Direction

abstract class AbstractTankBlockEntity(type: BlockEntityType<*>?) : BlockEntity(type), HasThermalProperties, Tickable, BlockEntityClientSerializable {

    override var pressure: Float = ThermalConstants.ATMOSPHERE_PRESSURE
    override var temperature: Float = ThermalConstants.ATMOSPHERE_TEMPERATURE
    override var workingFluid: WorkingFluid = WorkingFluid(20.8F, 44.64F, Malthermal / "air")

    var controller: AbstractTankBlockEntity? = null

    override fun writeNbt(nbt: NbtCompound?): NbtCompound {
        nbt!!.putFloat("pressure", pressure)
        nbt.putFloat("temperature", temperature)
        nbt.put("workingFluid", workingFluid.toCompound())
        return super.writeNbt(nbt)
    }

    override fun fromTag(state: BlockState?, tag: NbtCompound?) {
        super.fromTag(state, tag)
        pressure = tag!!.getFloat("pressure")
        temperature = tag.getFloat("temperature")
        workingFluid = WorkingFluid.fromCompound(tag.getCompound("workingFluid"))
    }

    override fun fromClientTag(tag: NbtCompound?) {
        this.fromTag(world!!.getBlockState(pos), tag)
    }

    override fun toClientTag(tag: NbtCompound?): NbtCompound {
        return writeNbt(tag)
    }

    override fun tick() {
        if (!world!!.isClient) {

        }
    }

}