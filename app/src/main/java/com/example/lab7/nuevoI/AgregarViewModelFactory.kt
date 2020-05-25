package com.example.lab7.nuevoI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab7.data.InvitadosDao

class AgregarViewModelFactory(
    private val dataSource: InvitadosDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AgregarViewModel::class.java)) {
            return AgregarViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}