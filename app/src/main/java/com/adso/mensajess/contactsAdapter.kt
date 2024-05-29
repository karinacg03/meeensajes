package com.adso.mensajess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(
    private val contactsList: List<Contact>,
    private val onContactClickListener: OnContactClickListener
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    interface OnContactClickListener {
        abstract val contactsRecyclerView: Any

        fun onContactClick(contact: Contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contactsList.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val profilePictureImageView: ImageView = itemView.findViewById(R.id.profilePictureImageView)

        fun bind(contact: Contact) {
            nameTextView.text = contact.name
            profilePictureImageView.setImageResource(contact.profilePicture)
            itemView.setOnClickListener {
                onContactClickListener.onContactClick(contact)
            }
        }
    }
}