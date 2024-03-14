package com.example.mytestapplication.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapplication.databinding.FragmentDashboardBinding
import com.example.mytestapplication.helper.ApiState
import com.example.mytestapplication.helper.UserdDataClass
import dagger.hilt.android.AndroidEntryPoint
import javax.security.auth.login.LoginException

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val usreListViewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchUserData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun fetchUserData() {
        usreListViewModel.userResult.observe(viewLifecycleOwner) { result: ApiState<UserdDataClass> ->
            when (result) {
                is ApiState.Loading -> {

                }

                is ApiState.Error -> {
                    Log.e("TAG", "fetchUserData: " + result.exception.toString())
                }

                is ApiState.ApiError -> {
                    Log.e("TAG", "fetchUserData: " + result.toString())
                }

                is ApiState.Success -> {
                    Log.e("TAG", "fetchUserData: " + result.toString())
                }
            }
        }

    }

}