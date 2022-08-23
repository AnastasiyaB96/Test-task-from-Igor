package com.alex.senior.pomidor.testihor.fragment.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alex.senior.pomidor.testihor.UsersViewModel
import com.alex.senior.pomidor.testihor.databinding.FragmentUsersBinding
import com.alex.senior.pomidor.testihor.room.EntityUser

class FragmentUsers : Fragment() {
//если такой вью модели еще нет то создает вью модел, а если уже есть, предоставляет существующую
    val viewModel: UsersViewModel by activityViewModels()

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val onUserClickedLambda: (EntityUser) -> (Unit) = {
        viewModel.onUserClicked(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.downloadNewUsers()
        viewModel.getAllUsers().observe(viewLifecycleOwner)
        {
            val adapter = AdapterUsers(it, onUserClickedLambda)
            binding.recyclerUsers.adapter = adapter
        }
    }
}