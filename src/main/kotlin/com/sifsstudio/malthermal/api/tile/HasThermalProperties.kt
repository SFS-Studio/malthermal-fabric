package com.sifsstudio.malthermal.api.tile

interface HasThermalProperties {
    val pressure: Float
    val temperature: Float
    val workingFluid: WorkingFluid
}