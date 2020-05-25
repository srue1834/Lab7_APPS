package com.example.lab7.nuevoI

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.lab7.R
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentAgregarBinding


/**
 * A simple [Fragment] subclass.
 */
class Agregar : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAgregarBinding>(
            inflater,
            R.layout.fragment_agregar, container, false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = AgregarViewModelFactory(dataSource)

        val agregarViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AgregarViewModel::class.java)

        binding.agregarViewModel = agregarViewModel

        binding.setLifecycleOwner(this)
        return binding.root
/*
        lateinit var viewModel: AgregarViewModel

        val roles = arrayListOf<String>("Organizador", "Fotografo", "Participante")
*/

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.agregar_menu, menu)

    }



}

