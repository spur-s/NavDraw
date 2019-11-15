package com.sparsh.navdraw.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sparsh.navdraw.R;
import com.sparsh.navdraw.adapter.ContactsAdapter;
import com.sparsh.navdraw.model.Contacts;

import java.util.ArrayList;
import java.util.List;



public class ContactsFragment extends Fragment {
    private RecyclerView recyclerView;

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contacts, container, false);


        recyclerView=view.findViewById(R.id.recyclerView);
        //making list
        List<Contacts> contactsList=new ArrayList<>();
        contactsList.add(new Contacts("Bhuwan", "9845895452", R.drawable.one));
        contactsList.add(new Contacts("Dahayang", "9845203157", R.drawable.two));
        contactsList.add(new Contacts("Saugat", "9812457820", R.drawable.three));
        contactsList.add(new Contacts("Bhuwan", "9845895452", R.drawable.four));
        contactsList.add(new Contacts("Dahayang", "9845203157", R.drawable.five));
        contactsList.add(new Contacts("Saugat", "9812457820", R.drawable.six));
        ContactsAdapter contactsAdapter=new ContactsAdapter(getContext(), contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return  view;

    }

}