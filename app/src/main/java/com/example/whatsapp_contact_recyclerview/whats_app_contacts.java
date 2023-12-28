package com.example.whatsapp_contact_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class whats_app_contacts extends AppCompatActivity {
    RecyclerView contactsRecycler;
    ContactsRecyclerAdapter adapter;
    List<contact>contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_contacts);
        contactsRecycler = findViewById(R.id.rv_contacts);
        initRecyclerView();
    }

    private void initRecyclerView() {
        createContactsList();

        adapter = new ContactsRecyclerAdapter(contactList);
        contactsRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener((position, contact) -> {
            Intent intent= new Intent(this,MainActivity2.class);
            intent.putExtra("name",contact.name);
            startActivity(intent);
        });
    }

    private void createContactsList() {
        contactList = new ArrayList<>(10000);
        for(int  i = 0 ;i<10000;i++){
            contactList.add(new contact(
                    i,"contact num "+ i ,"status for contact "+ i ,R.drawable.avatar_profile
            ));
        }
    }
}