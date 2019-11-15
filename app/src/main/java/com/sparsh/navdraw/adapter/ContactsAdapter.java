package com.sparsh.navdraw.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sparsh.navdraw.ContactsDetailsActivity;
import com.sparsh.navdraw.R;
import com.sparsh.navdraw.model.Contacts;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    Context mContext;
    List<Contacts> contactsList;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_fragment,parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final Contacts contacts=contactsList.get(position);
        holder.imgProfile.setImageResource(contacts.getImageId());
        holder.textViewphone.setText(contacts.getPhoneNo());
        holder.textViewname.setText(contacts.getName());
        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ContactsDetailsActivity.class);
                intent.putExtra("image", contacts.getImageId());
                intent.putExtra("phone", contacts.getPhoneNo());
                intent.putExtra("name", contacts.getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }


    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfile;
        TextView textViewname;
        TextView textViewphone;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile=itemView.findViewById(R.id.imgProfile);
            textViewname=itemView.findViewById(R.id.textViewname);
            textViewphone=itemView.findViewById(R.id.textViewphone);

        }
    }
}
