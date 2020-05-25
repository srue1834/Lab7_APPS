package com.example.lab7.roles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab7.data.DatosInvitados
import com.example.lab7.data.InvitadosDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RolesViewModel(val database: InvitadosDao) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var invitado = MutableLiveData<DatosInvitados?>()


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}