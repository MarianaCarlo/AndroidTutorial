package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Mariana", "marianacarlo@mail.com", "https://i.pinimg.com/originals/ba/d4/5a/bad45a40fa6e153ef8d1599ba875102c.png"));
        contacts.add(new Contact("Andres", "andres@mail.com", "https://cdn-icons-png.flaticon.com/512/146/146031.png"));
        contacts.add(new Contact("Camila", "marianacarlo@mail.com", "https://cdn-icons-png.flaticon.com/512/3220/3220315.png"));
        contacts.add(new Contact("Byan", "marianacarlo@mail.com", "https://cdn1.iconfinder.com/data/icons/user-pictures/101/malecostume-512.png "));
        contacts.add(new Contact("Reoy", "marianacarlo@mail.com", "https://cdn-icons-png.flaticon.com/512/194/194828.png"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}