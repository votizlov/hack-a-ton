package com.example.orientator2000.ui.open_doors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orientator2000.Event
import com.example.orientator2000.R
import com.example.orientator2000.User
import kotlinx.android.synthetic.main.user_list_item.view.*

class EventAdapter(val items : ArrayList<Event>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.company?.text = items.get(position).company
        holder?.date?.text = items.get(position).date
        holder?.descriptions?.text = items.get(position).description
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val company = view.tv_animal_type
    val date = view.desires
    val descriptions = view.city
}