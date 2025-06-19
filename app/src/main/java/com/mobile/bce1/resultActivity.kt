package com.mobile.bce1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.bce1.model.MyDatabaseHelper
import java.util.jar.Attributes

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_acivity)

        val dbHelper = MyDatabaseHelper(this)
        val cursor = dbHelper.getAllUserData()
        val UserList = mutableListOf<String>()

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
                val country = cursor.getString(cursor.getColumnIndexOrThrow("country"))
                val terms = cursor.getString(cursor.getColumnIndexOrThrow("terms"))

                UserList.add("Name: $name, Address: $address, Email: $email, Gender: $gender, Country: $country, Terms: $terms")

            } while (cursor.moveToNext())


//
//        val name = intent.getStringExtra("name")
//        val address = intent.getStringExtra("address")
//        val email = intent.getStringExtra("email")
//        val gender = intent.getStringExtra("gender")
//        val country = intent.getStringExtra("country")
//        val terms = intent.getStringExtra("terms")
//
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//        txtResult.text = """
//        Name: $name
//        Address: $address
//        Email: $email
//        Gender: $gender
//        Country: $country
//        Accepted Terms: $terms
//        """.trimIndent()
//


        }
        cursor.close()
        dbHelper.close()
        val listView = findViewById<ListView>(R.id.listViewUsers)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, UserList)
        listView.adapter = adapter


    }
}