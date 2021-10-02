package com.example.mausamweatherapp.presentation.state_test_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.domain.use_cases.GetNewsByStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor(
    private val getNewsByStateUseCase: GetNewsByStateUseCase,
//    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<StateScreenState>(StateScreenState())
    val state: State<StateScreenState> = _state

    init {

        getNews()
    }

    fun getNews(state: String = "punjab,in"){
        getNewsByStateUseCase(state = state).onEach {result->
            when(result){
                is Resource.Success ->{
                    _state.value = StateScreenState(news = result.data)
                }
                is Resource.Loading ->{
                    _state.value = StateScreenState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = StateScreenState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}