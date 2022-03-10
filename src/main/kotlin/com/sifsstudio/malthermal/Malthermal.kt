package com.sifsstudio.malthermal

import com.sifsstudio.malthermal.block.Blocks
import com.sifsstudio.malthermal.tile.BlockEntities
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier

object Malthermal: ModInitializer {
    const val MOD_ID = "malthermal"
    override fun onInitialize() {
        Blocks.register()
        BlockEntities.register()
    }

    operator fun div(path: String): Identifier {
        return Identifier(MOD_ID, path)
    }
}