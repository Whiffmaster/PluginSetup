package com.whiff.plug.cons

import com.whiff.plug.types.Types

data class CustomPlayer(override val name: String, override val uuid: String): Types.CustomPlayer {
}