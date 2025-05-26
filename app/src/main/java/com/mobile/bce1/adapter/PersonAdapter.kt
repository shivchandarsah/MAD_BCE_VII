package com.mobile.bce1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.mobile.bce1.R
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce1.model.Person



class PersonAdapter (
    private val context: Context,
    private val personList: List<Person>
    ):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nametxt)
        val phoneTextView: TextView = view.findViewById(R.id.phonetxt)
        val callButton: Button = view.findViewById(R.id.callbutton)
        val smsButton: Button = view.findViewById(R.id.smsbutton)
        val siteButton: Button = view.findViewById(R.id.sitebutton)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonAdapter.PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonAdapter.PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.nameTextView.text = person.name
        holder.phoneTextView.text = person.phone
    }


    override fun getItemCount(): Int = personList.size
}

