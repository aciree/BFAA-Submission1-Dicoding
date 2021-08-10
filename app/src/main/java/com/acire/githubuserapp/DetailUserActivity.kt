package com.acire.githubuserapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val KEY_USER = "key_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataUser = intent.getParcelableExtra<User>(KEY_USER) as User
        findViewById<ImageView>(R.id.tv_img).setImageResource(dataUser.photo)
        findViewById<TextView>(R.id.tv_name).text = dataUser.name
        findViewById<TextView>(R.id.tv_username).text = dataUser.username
        findViewById<TextView>(R.id.tv_company).text = dataUser.company
        findViewById<TextView>(R.id.tv_location).text = dataUser.location
        findViewById<TextView>(R.id.tv_repo_number).text = dataUser.repository
        findViewById<TextView>(R.id.tv_followers_number).text = dataUser.followers
        findViewById<TextView>(R.id.tv_following_number).text = dataUser.following

    }


}