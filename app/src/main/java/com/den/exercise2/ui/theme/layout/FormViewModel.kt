package com.den.exercise2.ui.theme.layout

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(FormViewModel())
    val stateUI: StateFlow<FormViewModel> = _stateUI.asStateFlow()
}