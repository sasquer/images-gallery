package com.sasquer.imagesgallery.ui.imagedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.sasquer.imagesgallery.R
import com.sasquer.imagesgallery.data.db.enteties.ImageInfo
import com.sasquer.imagesgallery.databinding.FragmentImageDetailsBinding
import com.sasquer.imagesgallery.di.Injectable
import com.sasquer.imagesgallery.navigation.Navigation
import javax.inject.Inject

class ImageDetailsFragment : Fragment(), Injectable {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: Navigation

    lateinit var binding: FragmentImageDetailsBinding

    private val viewModel by viewModels<ImageDetailsViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnClose.setOnClickListener {
            navigation.actionBackMainFromImageDetails()
        }

        subscribeViewModel()

        binding.item = ImageInfo()
        binding.viewModel = viewModel

        binding.setLifecycleOwner { lifecycle }
    }

    private fun subscribeViewModel() {
        viewModel.imageDetails.observe(viewLifecycleOwner, {
            binding.item = it
        })
    }
}