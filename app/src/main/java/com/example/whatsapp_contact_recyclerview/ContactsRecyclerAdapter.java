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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(itemview);
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

    OnItemClickListener onImageClickListener;
    OnItemClickListener OnItemClickListener;

    public void setOnImageClickListener(ContactsRecyclerAdapter.OnItemClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public void setOnItemClickListener(ContactsRecyclerAdapter.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onItemClick(int postion, contact contact);
    }

    @Override
    public int getItemCount() {
        if (items == null) return 0;
        return items.size();
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
}
