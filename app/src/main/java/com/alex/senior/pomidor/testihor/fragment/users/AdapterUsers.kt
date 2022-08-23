package com.alex.senior.pomidor.testihor.fragment.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alex.senior.pomidor.testihor.R
import com.alex.senior.pomidor.testihor.room.EntityUser

class AdapterUsers(private val usersList: List<EntityUser>, val onUserClickedLambda: (EntityUser) -> Unit) :
    RecyclerView.Adapter<AdapterUsers.UsersViewHolder>() {
    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.userName)

        fun bind(user: EntityUser, onUserClickedLambda: (EntityUser) -> Unit){
            userName.text = user.name
            userName.setOnClickListener {
                onUserClickedLambda(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return UsersViewHolder(layout)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = usersList[position]
        holder.bind(item, onUserClickedLambda)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}