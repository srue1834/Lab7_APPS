package com.example.lab7.data

import androidx.annotation.NonNull
import androidx.room.*
import androidx.room.ForeignKey.SET_DEFAULT
import com.example.lab7.roles.Roles

@Entity(tableName = "invitados_table")

data class DatosInvitados(

    @PrimaryKey(autoGenerate = true)
    var invitadoId: Long = 0L,

    @ColumnInfo(name = "nombre")
    val nombre: String = " ",

    @ColumnInfo(name = "telefono")
    val telefono: String = " ",

    @ColumnInfo(name = "correo")
    val correo: String = " " ,

    @ColumnInfo(name = "rol")
    val rol: String = " ")