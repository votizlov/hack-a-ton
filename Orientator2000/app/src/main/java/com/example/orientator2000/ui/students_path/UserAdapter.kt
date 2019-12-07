package com.example.orientator2000.ui.students_path

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orientator2000.R
import com.example.orientator2000.User
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserAdapter(val items : ArrayList<User>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvAnimalType?.text = items.get(position).type
        holder?.ap?.text = items.get(position).ap
        holder?.city?.text = items.get(position).city
        holder?.desires?.text = items.get(position).desires
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvAnimalType = view.tv_animal_type
    val desires = view.desires
    val city = view.city
    val ap = view.ap
}