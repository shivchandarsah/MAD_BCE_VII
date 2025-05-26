package com.mobile.bce1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ActivityForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.form_toolbar)
        val btnRegister = findViewById<Button>(R.id.btnSubmit)
        val txtResultName = findViewById<TextView>(R.id.tvResultName)
        val txtResultAddress = findViewById<TextView>(R.id.tvResultAdress)
        val txtResultEmail = findViewById<TextView>(R.id.tvResultEmail)
        val name = findViewById<EditText>(R.id.edtName)
        val address = findViewById<EditText>(R.id.edtAddress)
        val email = findViewById<EditText>(R.id.edtEmail)
        val country = findViewById<Spinner>(R.id.spCountry)
        val terms = findViewById<CheckBox>(R.id.cbTerms)
        val genderGroup = findViewById<RadioGroup>(R.id.rgroup)
        val male = findViewById<RadioButton>(R.id.rMale)
        val female = findViewById<RadioButton>(R.id.rFemale)



        //code to display status bar and back button
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    //code to display an
        btnRegister.setOnClickListener {
            val nameData = name.text.toString()
            val addressData = address.text.toString()
            val emailData = email.text.toString()

            val genderId = genderGroup.checkedRadioButtonId
            val genderText = findViewById<RadioButton>(genderId)?.text.toString()
            val countryText = country.selectedItem.toString()
            val acceptedTerms = terms.isChecked.toString()

            // txtResultName.setText("Name: "+nameData + " , Country:"+countryText)
            // txtResultAddress.setText("Address: "+addressData + " , Gender:"+genderText)
            // txtResultEmail.setText("Email: "+emailData + " , Terms:"+acceptedTerms)

            val intent = Intent(this, resultActivity::class.java).apply {
                putExtra("name", nameData)
                putExtra("address", addressData)
                putExtra("email", emailData)
                putExtra("gender", genderText)
                putExtra("country", countryText)
                putExtra("terms", acceptedTerms)
            }
            startActivity(intent)
        }
    }
}