package com.xgt.entrega_app_fragments_contra_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xgt.entrega_app_fragments_contra_api.databinding.ItemUserBinding
import com.xgt.entrega_app_fragments_contra_api.model.User

interface onUserListener {
    fun onClick(user: User)
}

class UserAdapter(private val onUserClicked: (User) -> Unit): ListAdapter<User, UserAdapter.ViewHolder>(UserItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemUserBinding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.tvFirstName.text = user.name.first
        holder.binding.tvLastName.text = user.name.last
        holder.binding.tvPais.text = user.nat
        Picasso.get()
            .load(user.picture.large)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.ivAvatar)



        holder.binding.root.setOnClickListener {
            onUserClicked(user)
        }
    }

    inner class ViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)


}

class UserItemCallback: DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
}