package com.alex.senior.pomidor.testihor.fragment.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alex.senior.pomidor.testihor.UsersViewModel
import com.alex.senior.pomidor.testihor.databinding.FragmentDataBinding
import com.bumptech.glide.Glide

class FragmentData : Fragment() {
    val viewModel: UsersViewModel by activityViewModels()

    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userPickedLiveData.observe(viewLifecycleOwner) {
            binding.name.text = it.name
            binding.address.text = it.address
            binding.dateOfBirth.text = it.dateBirth
            binding. phone.text = it.phone

            Glide.with(this)
                .load(it.photo)
                .into(binding.photoUser)
        }
    }
}