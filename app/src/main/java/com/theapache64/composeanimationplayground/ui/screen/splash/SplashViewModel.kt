package com.theapache64.composeanimationplayground.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theapache64.composeanimationplayground.BuildConfig
import com.theapache64.composeanimationplayground.util.flow.mutableEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    companion object {
        private const val SPLASH_DURATION_IN_MILLIS = 1500L
    }

    private val _versionName = MutableStateFlow("v${BuildConfig.VERSION_NAME}")
    val versionName = _versionName.asStateFlow()

    private val _isSplashFinished = mutableEventFlow<Boolean>()
    val isSplashFinished = _isSplashFinished.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(SPLASH_DURATION_IN_MILLIS)
            _isSplashFinished.tryEmit(true)
        }
    }
}