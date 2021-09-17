package com.theapache64.composeanimationplayground.ui.screen.dashboard

import androidx.lifecycle.ViewModel
import com.theapache64.composeanimationplayground.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    private val _greetingsRes = MutableStateFlow(R.string.label_hello_world)
    val greetingsRes = _greetingsRes.asStateFlow()

    fun onClickMeClicked() {
        _greetingsRes.value = R.string.label_hello_compose
    }
}