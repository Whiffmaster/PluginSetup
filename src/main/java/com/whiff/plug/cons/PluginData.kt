package com.whiff.plug.cons

import com.whiff.plug.types.Types

object PluginData {
    val chunkLoaders : MutableList<ChunkLoader> = mutableListOf()
    val areas : MutableMap<String, Types.Area> = mutableMapOf()
    val structures : MutableMap<String, Types.Structure> = mutableMapOf()



}