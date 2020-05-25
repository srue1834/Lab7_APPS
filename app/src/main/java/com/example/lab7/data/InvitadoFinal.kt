package com.example.lab7.data

import androidx.room.Embedded

data class InvitadoFinal(
    @Embedded
    val invitado: DatosInvitados,

    val rol: DatosRoles)