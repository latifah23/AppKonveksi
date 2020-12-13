package com.appkonveksi.app.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.appkonveksi.app.data.repository.AuthRepository
import com.appkonveksi.app.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
     val parent : AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding:FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
    }
    private fun init() {
        viewModel.authRegister.observe(viewLifecycleOwner) {
            if (it.isConsumed){
                Log.i("Register", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(parent, "Anda Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            }
            it.isConsumed = true
        }
    }

}