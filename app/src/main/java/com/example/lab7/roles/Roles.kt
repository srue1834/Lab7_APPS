package com.example.lab7.roles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.lab7.R
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentRolesBinding

/**
 * A simple [Fragment] subclass.
 */

class Roles : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRolesBinding>(
            inflater,
            R.layout.fragment_roles, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = RolesViewModelFactory(dataSource)

        val rolesViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(RolesViewModel::class.java)

        binding.rolesViewModel = rolesViewModel

        binding.setLifecycleOwner(this)
        return binding.root
    }

}

