package com.example.quadb

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quadb.databinding.HomeFragmentBinding

class HomeFragment : Fragment(),MoviesListAdapter.ListItemListener {

    private lateinit var viewModel: HomeViewModel
private lateinit var binding:HomeFragmentBinding
private lateinit var adapter:MoviesListAdapter
private val args:HomeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title="Home"
    binding= HomeFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        with(binding.recyclerView){
            setHasFixedSize(true)
        }
        binding.editTextTextPersonName.setOnFocusChangeListener { view, b ->
            if(b){
                val text=binding.editTextTextPersonName.text.toString()
                val action=HomeFragmentDirections.actionHomeFragmentToSearchFragment(text)
                findNavController().navigate(action)
            }
        }
        if(args.search!="all"){
                        binding.editTextTextPersonName.setText(args.search)

        }
        viewModel.getMovies(args.search!!)
        viewModel.movies.observe(viewLifecycleOwner, Observer {
//            Log.i("hello",it.toString())
            adapter= MoviesListAdapter(it,this@HomeFragment)
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        })
//        viewModel.getMovies()

        return binding.root
    }

    override fun showMovie(movieId:Int) {
        val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(movieId)
        findNavController().navigate(action)
    }


}