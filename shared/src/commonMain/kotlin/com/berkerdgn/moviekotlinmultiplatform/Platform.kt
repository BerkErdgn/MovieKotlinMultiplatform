package com.berkerdgn.moviekotlinmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform