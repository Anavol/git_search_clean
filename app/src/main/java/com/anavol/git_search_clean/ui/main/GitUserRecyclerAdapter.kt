package com.anavol.git_search_clean.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anavol.git_search_clean.R
import com.anavol.git_search_clean.data.domain.entity.GitUserEntity
import kotlinx.android.synthetic.main.user_list_item.view.*

class GitUserRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<GitUserEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GitUserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GitUserViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(userList: List<GitUserEntity>) {
        items = userList
    }
}

class GitUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val user_name = itemView.user_name
    val user_url = itemView.user_link

    fun bind(gitUser: GitUserEntity) {
        user_name.text = gitUser.login
        user_url.text = gitUser.url
    }
}