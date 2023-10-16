package com.hamza.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.api.usecase.LaunchesUseCaseResult
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.hamza.common.BaseViewModel
import com.hamza.presentation.ui.data.LaunchesDetailsUiModel
import com.hamza.presentation.ui.data.LaunchesUiModel
import com.hamza.presentation.ui.data.toLaunchesDetailsModel
import com.hamza.presentation.ui.data.toListLaunchesUiModel

class LaunchesViewModel (val getLaunchesUseCase: LaunchesUseCase): BaseViewModel() {

    private val _launchesState = MutableStateFlow(LaunchesState())
    val launches: StateFlow<LaunchesState> = _launchesState.asStateFlow()
    private val _launchesDetails = MutableStateFlow<LaunchesDetailsUiModel?>(null)
    val launchesDetails: StateFlow<LaunchesDetailsUiModel?> = _launchesDetails.asStateFlow()

   // val savedLaunchesList: LiveData<List<LaunchesTable>> = launchesRepository.allLaunches

    init {
        loadLaunches()
    }

     fun loadLaunches() {
        fetchData()
    }

    fun retry() {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _launchesState.update { launchesState ->
                launchesState.copy(isLoading = true)
            }
            viewModelScope.launch {
                when(val launchesData = getLaunchesUseCase()) {
                    is LaunchesUseCaseResult.Success -> {
                        _launchesState.update { launchesState ->
                            launchesState.copy(isLoading = false, isError = false, errorMessage = null, launches = launchesData.launches.toListLaunchesUiModel())
                        }
                    }
                    is LaunchesUseCaseResult.Error -> {
                        _launchesState.update { launchesState ->
                            launchesState.copy(isLoading = false, isError = true, errorMessage = launchesData.throwable?.message)
                        }
                    }
                    else -> {
                        _launchesState.update { launchesState ->
                            launchesState.copy(isLoading = false, isError = true)
                        }
                    }
                }
            }
        }
    }

    fun fetchDetails(id: String) {
        viewModelScope.launch {
            when (val list = getLaunchesUseCase()) {
                is LaunchesUseCaseResult.Success -> {
                    val launches = list.launches.firstOrNull { it.id == id }
                    _launchesDetails.emit(launches!!.toLaunchesDetailsModel())
                }
                else -> {
                    //do nothing
                }
            }
        }
    }

//    fun getAllSavedLaunches() : List<LaunchesTable>{
//      return  launchesRepository.getAllSavedLaunches()
//    }
//
//    fun addEmployee(launch: LaunchesTable) {
//        launchesRepository.addLaunches(launch)
//        getAllSavedLaunches()
//    }
}

data class LaunchesState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val launches: List<LaunchesUiModel> = emptyList()
)