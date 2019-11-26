package com.example.recyclerview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

   Context mContext;
   List<contacts> contactsList;

   //constructor , to recieve data from the activity

    public ContactsAdapter(Context mContext, List<contacts> contactsList)
    {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }


    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.layout_contacts,parent, false);

        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactsViewHolder holder, int position) {

        contacts contacts = contactsList.get(position);
        holder.imgProfile.setImageResource(contacts.getImageId());

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProfile;
        TextView txtname, txtcontacts;

        public ContactsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageView);
            txtname = itemView.findViewById(R.id.txtname);
            txtcontacts = itemView.findViewById(R.id.txtcontact);

        }

    }
}
