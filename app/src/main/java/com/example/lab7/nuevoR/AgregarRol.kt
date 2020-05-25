package com.example.lab7.nuevoR

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.lab7.R
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentAgregarRolBinding

/**
 * A simple [Fragment] subclass.
 */
class AgregarRol : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAgregarRolBinding>(
            inflater,
            R.layout.fragment_agregar_rol, container, false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = AgregarRolViewModelFactory(dataSource)

        val agregarRolViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AgregarRolViewModel::class.java)

        binding.agregarRolViewModel = agregarRolViewModel

        binding.setLifecycleOwner(this)
        return binding.root



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.agregar_menu, menu)

    }



}

