package com.example.lab7.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab7.invitados.Invitados
import com.example.lab7.roles.Roles

@Dao
interface InvitadosDao {

    @Insert
    fun insert(datosInvitados: DatosInvitados)

    @Update
    fun update(datosInvitados: DatosInvitados)

    @Insert
    fun insert(datosRoles: DatosRoles)

    @Query("SELECT * FROM invitados_table ORDER BY invitadoId DESC")
    fun getRoles(): LiveData<List<DatosRoles>>

    @Query("SELECT * FROM invitados_table ORDER BY invitadoId DESC")
    fun getInvitados(): LiveData<List<DatosInvitados>>

    @Query("SELECT * FROM invitados_table ORDER BY invitadoId DESC LIMIT 1")
    fun getInvitado(): DatosInvitados?

    @Query("SELECT * FROM invitados_table ORDER BY invitadoId DESC LIMIT 1")
    fun getRol(): DatosInvitados?

    @Query("SELECT * FROM invitados_table ORDER BY invitadoId DESC")
    fun getInvitadoFinal(): LiveData<List<InvitadoFinal>>

    @Query("DELETE FROM invitados_table")
    fun clear()
}