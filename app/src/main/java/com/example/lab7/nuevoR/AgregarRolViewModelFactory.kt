package com.example.lab7.nuevoR

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab7.data.InvitadosDao

class AgregarRolViewModelFactory(
    private val dataSource: InvitadosDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AgregarRolViewModel::class.java)) {
            return AgregarRolViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}