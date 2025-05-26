package com.mobile.bce1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mobile.bce1.model.Person
import com.mobile.bce1.adapter.PersonAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PersonActivity : AppCompatActivity() {

private lateinit var recyclerView: RecyclerView
    private lateinit var personAdapter: PersonAdapter
    private val personList = listOf(
            Person("Shiv sah", "+977-9813768889", "https://shivsah.com.np"),
            Person("kishan yadav", "+977-9813768889", "https://shivsah.com.np"),
            Person( "santu yadav", "+977-9813768889", "https://shivsah.com.np")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_person)


        // set up toolbar as action bar
        val toolbar:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Person List"
            setDisplayHomeAsUpEnabled(true)// show back button
        }

        // Handle back button click
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()  // navigate back
        }

            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            personAdapter = PersonAdapter(this, personList)
            recyclerView.adapter = personAdapter


    }
}