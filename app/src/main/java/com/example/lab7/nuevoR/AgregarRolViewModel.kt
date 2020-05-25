package com.example.lab7.nuevoR

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab7.data.DatosRoles
import com.example.lab7.data.InvitadosDao
import kotlinx.coroutines.*

class AgregarRolViewModel(val database: InvitadosDao) : ViewModel() {

    val text = MutableLiveData<String>()
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertRol(datosRoles: Any) {
        uiScope.launch {
            insert(datosRoles as DatosRoles)
        }
    }

    private suspend fun insert(datosRoles: DatosRoles) {
        withContext(Dispatchers.IO) {
            database.insert(DatosRoles(nombre = text.value ?: "", descripcion= text.value ?: ""))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}