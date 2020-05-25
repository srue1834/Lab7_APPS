package com.example.lab7.invitados

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lab7.data.InvitadoFinal
import com.example.lab7.data.InvitadosDao


class InvitadosViewModel(val database:InvitadosDao):  ViewModel() {

        private val invitados = database.getInvitadoFinal()

        val invitadosF = Transformations.map(invitados) {
            buildInvitadosF(it)
        }

        private fun buildInvitadosF(invitadoFinal: List<InvitadoFinal>) : String{
            val invitadosF = StringBuilder()
            for (inv in invitadoFinal){
                invitadosF.append("ID: ${inv.invitado.invitadoId}\n" +
                        "Nombre: ${inv.invitado.nombre}\n" +
                        "Telefono: ${inv.invitado.telefono}\n" +
                        "Correo electronico: ${inv.invitado.correo}\n" +
                        "Rol: ${inv.invitado.rol}\n\n")
            }
            return invitadosF.toString()
        }
    }
