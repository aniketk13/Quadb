package com.example.quadb

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quadb.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding:SearchFragmentBinding
    private lateinit var text:String
    private val args:SearchFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        binding= SearchFragmentBinding.inflate(inflater,container,false)
requireActivity().title="Search"
        if(args.search!="not initialized")
        {binding.editTextTextPersonName2.setText(args.search)
                binding.editTextTextPersonName2.requestFocus()}
        else
        {
            binding.editTextTextPersonName2.setText("")
        }
//        binding.editTextTextPersonName2.requestFocus()
        binding.editTextTextPersonName2.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->
            if(actionId==EditorInfo.IME_ACTION_GO){
                text=binding.editTextTextPersonName2.text.toString()
                if(text=="")
                    text="all"
                val action=SearchFragmentDirections.actionSearchFragmentToHomeFragment(text)
                findNavController().navigate(action)
            }
        true
        })
        return binding.root
    }
    }
