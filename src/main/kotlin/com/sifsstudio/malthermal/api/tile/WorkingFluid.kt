package com.sifsstudio.malthermal.api.tile

import net.minecraft.nbt.NbtCompound
import net.minecraft.util.Identifier

data class WorkingFluid(
    val heatCapacity: Float, // isochoric
    val quantity: Float, // moles
    val id: Identifier
) {
    companion object {
        fun fromCompound(compound: NbtCompound): WorkingFluid {
            return WorkingFluid(compound.getFloat("heatCapacity"), compound.getFloat("quantity"), Identifier(compound.getString("id")))
        }
    }

    fun toCompound(): NbtCompound {
        val compound = NbtCompound()
        compound.putFloat("heatCapacity", heatCapacity)
        compound.putFloat("quantity", quantity)
        compound.putString("id", id.toString())
        return compound
    }
}