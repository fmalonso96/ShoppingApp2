package com.example.shoppingappmvvm.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppingappmvvm.R
import com.example.shoppingappmvvm.databinding.ActivityMainBinding
import com.example.shoppingappmvvm.ui.base.ViewModelFactory
import com.example.shoppingappmvvm.ui.main.adapter.ProductAdapter
import com.example.shoppingappmvvm.ui.main.view.ProductDetailActivity.Companion.EXTRA_PRODUCT
import com.example.shoppingappmvvm.ui.main.viewmodel.MainActivityViewModel
import com.example.shoppingappmvvm.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun setupViewModel() {
        mainActivityViewModel = ViewModelProvider(this, ViewModelFactory())
            .get(MainActivityViewModel::class.java)
    }

    private fun setupObserver() {
        mainActivityViewModel.currentProducts.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    val adapter = ProductAdapter(it.data!!, onClick = {
                        val intent = Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra(EXTRA_PRODUCT, it)
                        }
                        startActivity(intent)
                    })
                    binding.recyclerView.adapter = adapter
                }

                Status.ERROR -> {
                }
            }
        })
    }
}