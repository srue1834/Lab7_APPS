package com.example.lab7.nuevoI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab7.data.DatosInvitados
import com.example.lab7.data.InvitadosDao
import com.example.lab7.invitados.Invitados
import kotlinx.coroutines.*

class AgregarViewModel(val database: InvitadosDao) : ViewModel() {

    val text = MutableLiveData<String>()
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertInvitado(datosInvitados: Any) {
        uiScope.launch {
            insert(datosInvitados as DatosInvitados)
        }
    }

    private suspend fun insert(datosInvitados: DatosInvitados) {
        withContext(Dispatchers.IO) {
            database.insert(DatosInvitados(nombre = text.value ?: "", telefono = text.value ?: "", correo = text.value ?: "", rol = text.value ?: ""))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}