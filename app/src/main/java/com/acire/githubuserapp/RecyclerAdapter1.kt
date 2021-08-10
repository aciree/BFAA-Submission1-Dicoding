package com.acire.githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter1 : RecyclerView.Adapter<RecyclerAdapter1.MyViewHolder>() {

    internal var users = arrayListOf<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.txt_name)
        private val txtUsername: TextView = itemView.findViewById(R.id.txt_username)
        private val txtLocation: TextView = itemView.findViewById(R.id.txt_location)
        private val imgPhoto: CircleImageView = itemView.findViewById(R.id.img_photo)

        fun bind(user: User) {
            txtName.text = user.name
            txtUsername.text = user.username
            txtLocation.text = user.location
            imgPhoto.setImageResource(user.photo)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.KEY_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        //to connect layout item
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter1.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter1.MyViewHolder, position: Int) {
        //provide data to VH sequentially
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        //number of items being shown
        return users.size
    }
}