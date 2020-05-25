package com.example.lab7.resultados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.example.lab7.R
import com.example.lab7.data.InvitadosDataBase
import com.example.lab7.databinding.FragmentResultadosBinding

/**
 * A simple [Fragment] subclass.
 */
class Resultados : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentResultadosBinding>(inflater,
            R.layout.fragment_resultados,container,false)
        binding.reinciarB.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_resultados_to_titleFragment)
        }
        val application = requireNotNull(this.activity).application

        val dataSource = InvitadosDataBase.getInstance(application).invitadosDao

        val viewModelFactory = ResultadosViewModelFactory(dataSource)

        val resultadosViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ResultadosViewModel::class.java)

        binding.resultadosViewModel = resultadosViewModel

        binding.setLifecycleOwner(this)
        return binding.root
    }



}

