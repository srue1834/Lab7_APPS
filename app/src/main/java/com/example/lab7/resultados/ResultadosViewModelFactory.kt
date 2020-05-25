package com.example.lab7.resultados

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab7.data.InvitadosDao

class ResultadosViewModelFactory(
    private val dataSource: InvitadosDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultadosViewModel::class.java)) {
            return ResultadosViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}