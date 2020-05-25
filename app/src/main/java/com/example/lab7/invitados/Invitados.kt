package com.example.lab7.invitados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.lab7.R
import com.example.lab7.data.DatosInvitados
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentInvitadosBinding

/**
 * A simple [Fragment] subclass.
 */


class Invitados() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentInvitadosBinding>(inflater,
            R.layout.fragment_invitados,container,false)
        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = InvitadosViewModelFactory(dataSource)

        val invitadosViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(InvitadosViewModel::class.java)

        binding.invitadosViewModel = invitadosViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }
}