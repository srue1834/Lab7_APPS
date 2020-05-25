package com.example.lab7.invitados

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab7.data.InvitadosDao

class InvitadosViewModelFactory(
    private val dataSource: InvitadosDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InvitadosViewModel::class.java)) {
            return InvitadosViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}