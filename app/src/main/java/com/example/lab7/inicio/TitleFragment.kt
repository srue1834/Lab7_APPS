package com.example.lab7.inicio

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.lab7.R
import com.example.lab7.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */

class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.iniciarB.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_registro)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }
}

