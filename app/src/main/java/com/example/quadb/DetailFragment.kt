package com.example.quadb

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.api.RetrofitInstance
import com.example.quadb.databinding.DetailFragmentBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding:DetailFragmentBinding
    private lateinit var buttonUrl:String
private val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding= DetailFragmentBinding.inflate(inflater,container,false)
        Log.i("hello",args.movieId.toString())
        viewModel.getSelectedMovie(args.movieId)
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            binding.name.text=it.name
            binding.language.text=it.language
            binding.summary.text=it.summary
            buttonUrl=it.url
            if(it.image!=null)
                Picasso.get().load(it.image.medium).into(binding.imageView)
            Log.i("Hello",it.toString())
        })
        binding.movieUrl.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(buttonUrl)
            startActivity(intent)
        }
        return binding.root
    }


}