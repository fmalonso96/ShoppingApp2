package com.example.shoppingappmvvm.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.shoppingappmvvm.R
import com.example.shoppingappmvvm.data.model.Product
import com.example.shoppingappmvvm.databinding.ActivityProductDetailBinding
import com.example.shoppingappmvvm.ui.main.viewmodel.ProductDetailViewModel

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var productDetailViewModel: ProductDetailViewModel
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)

        product = intent.extras?.getSerializable(EXTRA_PRODUCT) as Product

        setupViewModel()
        setupUI()
    }

    private fun setupViewModel() {
        //instancia del viewmodel para usar room
    }

    private fun setupUI() {
        Glide.with(this).load(product.image).into(binding.ivProductDescription)
        binding.tvProductDescriptionTitle.text = product.title
        binding.tvProductDescription.text = product.description
    }

    companion object {
        const val EXTRA_PRODUCT = "product"
    }
}