package com.berkerdgn.moviekotlinmultiplatform.util

import com.berkerdgn.moviekotlinmultiplatform.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}