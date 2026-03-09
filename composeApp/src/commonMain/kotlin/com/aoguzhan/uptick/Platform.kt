package com.aoguzhan.uptick

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform