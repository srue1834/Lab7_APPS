package com.example.lab7.registro

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.lab7.R
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentRegistroBinding

/**
 * A simple [Fragment] subclass.
 */

class Registro() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRegistroBinding>(
            inflater,
            R.layout.fragment_registro, container, false)

        setHasOptionsMenu(true)
        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = RegistroViewModelFactory(dataSource)

        val registroViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(RegistroViewModel::class.java)

        binding.registroViewModel = registroViewModel

        binding.setLifecycleOwner(this)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.registrados_menu, menu)

    }

}





