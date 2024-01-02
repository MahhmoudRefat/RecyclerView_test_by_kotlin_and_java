package com.example.whatsapp_contact_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsapp_contact_recyclerview.databinding.ActivityWhatsAppChatsBinding

class WhatsAppChats : AppCompatActivity() {
    private lateinit var binding: ActivityWhatsAppChatsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatsAppChatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    lateinit var adapter: WhatsAppChatAdapter
    lateinit var ContactList: MutableList<Contact_kt>
    private fun initRecyclerView() {
        createContactList();
        adapter = WhatsAppChatAdapter(ContactList)
        binding.rvContacts.adapter = adapter
    }

    private fun createContactList() {
        ContactList = arrayListOf()
        for (i in 0..1000) {
            ContactList.add(Contact_kt(1, "contact num $i ", "status for contact  ", R.drawable.avatar_profile));
        }
    }
}