package com.berkerdgn.moviekotlinmultiplatform.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher{
    val io : CoroutineDispatcher

}

internal  expect  fun provideDispatcher(): Dispatcher


//expect(Bunu bulmak zorundasın, Bunu um ) vs actual(Gercekten bunun uygulanmış hali)