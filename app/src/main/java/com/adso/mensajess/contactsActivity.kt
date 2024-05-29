package com.adso.mensajess

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactsActivity : AppCompatActivity(), ContactsAdapter.OnContactClickListener {

    override lateinit var contactsRecyclerView: RecyclerView
    private val contactsList = mutableListOf<Contact>()
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView) // Initialize RecyclerView
        initContactsList()
        initRecyclerView()
    }

    private fun initContactsList() {
        val contact1 = Contact(1, "Juan Pérez", R.drawable.nino)
        val contact2 = Contact(2, "María Gómez", R.drawable.chico)
        val contact3 = Contact(3, "Carlos Rodríguez", R.drawable.mujer)
        contactsList.addAll(listOf(contact1, contact2, contact3))
    }

    private fun initRecyclerView() {
        contactsAdapter = ContactsAdapter(contactsList, this)
        contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.adapter = contactsAdapter
    }

    override fun onContactClick(contact: Contact) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("contactId", contact.id)
        startActivity(intent)
    }
}
