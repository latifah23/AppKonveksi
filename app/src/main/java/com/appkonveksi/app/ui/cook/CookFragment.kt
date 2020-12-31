package com.appkonveksi.app.ui.cook

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appkonveksi.app.R
import com.appkonveksi.app.databinding.FragmentCookBinding
import com.appkonveksi.app.ui.home.CookAdapter
import com.appkonveksi.app.ui.home.MainActivity

class CookFragment : Fragment() {

    private val parent: MainActivity by lazy {activity as MainActivity}
    private lateinit var binding: FragmentCookBinding
    private val viewModel: CookViewModel by lazy {CookViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCookBinding.inflate(inflater, container,false).apply {
            viewModel = this@CookFragment.viewModel
            lifecycleOwner = this@CookFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = CookAdapter(parent)
        viewModel.listCook()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listCook()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if(it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if(!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}