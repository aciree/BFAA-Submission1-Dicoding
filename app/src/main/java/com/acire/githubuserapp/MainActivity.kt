package com.acire.githubuserapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rv_list)
        val recycleAdapter1 = RecyclerAdapter1()
        recyclerView.adapter = recycleAdapter1
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Add data from resource
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUsername = resources.getStringArray(R.array.data_username)
        val dataCompany = resources.getStringArray(R.array.data_location)
        val dataLocation = resources.getStringArray(R.array.data_company)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        //not using recycle on this one otherwise the apk won't run
        val dataRepository = resources.getStringArray(R.array.data_repository)
        val dataFollowers = resources.getStringArray(R.array.data_followers)
        val dataFollowing = resources.getStringArray(R.array.data_following)

        //Add data to data class User
        val users = arrayListOf<User>()
        for (position in dataName.indices) {
            val user = User(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            users.add(user)
        }

        //Add data class to adapter
        recycleAdapter1.users = users

        //Gives action to list
        recyclerView.setOnClickListener {
            val intent = Intent(this, DetailUserActivity::class.java)
            intent.putExtra(DetailUserActivity.KEY_USER, users)
            startActivity(intent)
        }
    }
}