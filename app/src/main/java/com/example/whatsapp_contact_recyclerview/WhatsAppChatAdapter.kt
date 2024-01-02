package com.example.whatsapp_contact_recyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp_contact_recyclerview.ContactsRecyclerAdapter.ViewHolder

class WhatsAppChatAdapter(val items: List<Contact_kt>)
    : RecyclerView.Adapter<WhatsAppChatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.contact_image)
        val name:TextView = itemView.findViewById(R.id.name_tv)
        val status:TextView = itemView.findViewById(R.id.status_tv)
    }
    override fun getItemCount(): Int = items.size ?:0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = items?.get(position)
        if(contact != null) {
            holder.name.text = contact?.name
            holder.image.setImageResource(contact?.imageId ?: R.drawable.avatar_profile)
            holder.status.text = contact?.status
        }
    }
}