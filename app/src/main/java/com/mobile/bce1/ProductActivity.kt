package com.mobile.bce1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce1.adapter.ProductAdapter
import com.mobile.bce1.model.Product
import com.mobile.bce1.model.Rating
import com.mobile.bce1.network.Retrofitclient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val toolbar = findViewById<Toolbar>(R.id.toolbarProduct)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Product"

        val postButton = findViewById<Button>(R.id.postProduct)
        recyclerView = findViewById(R.id.productrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postButton.setOnClickListener {
            val sampleProduct = Product(
                id = 21,
                title = "Sample Product",
                price = 9.99,
                description = "This is a sample product",
                category = "Electronics",
                image = "https://example.com/image.jpg",
                rating = Rating(rate = 4.5, count = 100)
            )

            Retrofitclient.api.postProduct(sampleProduct).enqueue(object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@ProductActivity, "Product posted successfully!", Toast.LENGTH_SHORT).show()
                        fetchProducts() // Refresh the list
                    } else {
                        Toast.makeText(this@ProductActivity, "Failed to post product", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    Toast.makeText(this@ProductActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

        fetchProducts()
    }

    private fun fetchProducts() {
        Retrofitclient.api.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    recyclerView.adapter = ProductAdapter(products ?: emptyList())
                } else {
                    Toast.makeText(this@ProductActivity, "Failed to load products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@ProductActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
