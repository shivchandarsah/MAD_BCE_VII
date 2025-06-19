package com.mobile.bce1.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.mobile.bce1.R
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce1.model.Person



class PersonAdapter(
    private val context: Context,
    private val personList: List<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nametxt)
        val phoneTextView: TextView = view.findViewById(R.id.phonetxt)
        val callButton: Button = view.findViewById(R.id.callbutton)
        val smsButton: Button = view.findViewById(R.id.smsbutton)
        val siteButton: Button = view.findViewById(R.id.sitebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.nameTextView.text = person.name
        holder.phoneTextView.text = person.phone

        Log.d("PersonAdapter", "Binding person: ${person.name}")

        holder.callButton.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${person.phone}")
            }
            context.startActivity(intentCall)
        }

        holder.smsButton.setOnClickListener {
            val intentSms = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("sms:${person.phone}")
            }
            context.startActivity(intentSms)
        }

        holder.siteButton.setOnClickListener {
            val intentSite = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(person.website)
            }
            context.startActivity(intentSite)
        }

        holder.itemView.setOnClickListener {
            val intentShare = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Name: ${person.name}\nPhone: ${person.phone}")
            }
            context.startActivity(Intent.createChooser(intentShare, "Share in:"))
        }
    }
    // Moved getItemCount outside of onBindViewHolder
    override fun getItemCount(): Int = personList.size
}