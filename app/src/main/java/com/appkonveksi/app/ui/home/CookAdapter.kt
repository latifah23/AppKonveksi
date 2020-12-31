package com.appkonveksi.app.ui.home

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.appkonveksi.app.R
import com.appkonveksi.app.data.model.Cook
import com.appkonveksi.app.databinding.ItemCookBinding
import com.appkonveksi.app.ui.base.BaseAdapter
import com.appkonveksi.app.ui.cook.CookActivity

class CookAdapter(val context: Context) : BaseAdapter<Cook>(R.layout.item_cook) {
    override fun onBind(binding: ViewDataBinding?, data: Cook) {
        val mBinding = binding as ItemCookBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Cook) {
        val intent = Intent(context, CookActivity::class.java)
        intent.putExtra(CookActivity.OPEN_COOK, data)
        context.startActivity(intent)
    }
}