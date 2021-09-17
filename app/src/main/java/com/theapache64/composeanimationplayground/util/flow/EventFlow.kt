package com.theapache64.composeanimationplayground.util.flow

import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * To fire events.
 * This flow won't fire the last value for each collect call.
 * This observer will only be invoked on `tryEmit` calls.
 * (replacement for SingleLiveEvent :D)
 *
 * Created by theapache64 : Jan 08 Fri,2021 @ 01:40
 */
fun <T> mutableEventFlow(): MutableSharedFlow<T> {
    return MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1
    )
}
