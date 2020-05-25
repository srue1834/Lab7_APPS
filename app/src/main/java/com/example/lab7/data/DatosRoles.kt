package com.example.lab7.data

import androidx.room.*


@Entity(tableName = "invitados_table")

data class DatosRoles(

    @PrimaryKey(autoGenerate = true)
    var invitadoId: Long = 0L,

    @ColumnInfo(name = "nombre")
    val nombre: String = " ",

    @ColumnInfo(name = "descripcion")
    val descripcion: String = " ")