package com.sasquer.imagesgallery.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.databinding.FragmentMainBinding
import com.sasquer.imagesgallery.di.Injectable
import com.sasquer.imagesgallery.navigation.Navigation
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: Navigation

    lateinit var binding: FragmentMainBinding

    private val viewModel by viewModels<MainViewModel> { factory }

    private val imageAdapter = ImageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvImages.run {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = imageAdapter
        }

        subscribeViewModel()

        binding.setLifecycleOwner { lifecycle }
        binding.viewModel = viewModel
    }

    private fun subscribeViewModel() {
        viewModel.images.observe(viewLifecycleOwner, Observer {
            Log.e("images", it.toString())
            imageAdapter.submitList(it)
        })
    }
}