package com.example.whatsapp_contact_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.ViewHolder> {
    List<contact> items;

    public ContactsRecyclerAdapter(List<contact> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView profileImage;
        TextView status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            profileImage = itemView.findViewById(R.id.contact_image);
            status = itemView.findViewById(R.id.status_tv);
        }
    }
            /*the adapter abstract methode start from here  */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public int getItemCount() {
        if (items == null) return 0;
        return items.size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        contact item = items.get(position);
        holder.name.setText(item.name);
        holder.status.setText(item.status);
        holder.profileImage.setImageResource(item.image_id);
        if(OnItemClickListener != null){
            holder.itemView.setOnClickListener(v -> {
                OnItemClickListener.onItemClick(position, item);
            });}
        if (onImageClickListener != null) {
            holder.profileImage.setOnClickListener(v -> {
                onImageClickListener.onItemClick(position, item);
            });
        }
    }

            /*The click code start from here */
    /* we create the on click listener away from the adapter code to make it as a dynamic click */
    OnItemClickListener onImageClickListener;
    OnItemClickListener OnItemClickListener;

    public void setOnImageClickListener(ContactsRecyclerAdapter.OnItemClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
        //setter function
    }

    public void setOnItemClickListener(ContactsRecyclerAdapter.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
        //setter function
    }

    interface OnItemClickListener {
        void onItemClick(int postion, contact contact);
    }


}
