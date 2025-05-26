package com.mobile.bce1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.jar.Attributes

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_acivity)



        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val terms = intent.getStringExtra("terms")

        val txtResult = findViewById<TextView>(R.id.txtResult)
        txtResult.text = """
        Name: $name
        Address: $address
        Email: $email
        Gender: $gender
        Country: $country
        Accepted Terms: $terms
        """.trimIndent()




    }
}