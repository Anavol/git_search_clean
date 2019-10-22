package com.anavol.git_search_clean.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anavol.git_search_clean.R
import com.anavol.git_search_clean.data.domain.entity.GitUserEntity

class CustomAdapter(val userList: List<GitUserEntity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: GitUserEntity) {
            val textViewName = itemView.findViewById(R.id.user_name) as TextView
            val textViewUrl  = itemView.findViewById(R.id.user_link) as TextView
            textViewName.text = user.login
            textViewUrl.text = user.url
        }
    }
}