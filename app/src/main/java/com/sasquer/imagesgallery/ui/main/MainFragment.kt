package com.sasquer.imagesgallery.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.di.Injectable
import com.sasquer.imagesgallery.navigation.Navigation
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: Navigation

    private val viewModel by viewModels<MainViewModel> { factory }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        viewModel.images.observe(viewLifecycleOwner, Observer {
            Log.e("images", it.toString())
        })
    }
}