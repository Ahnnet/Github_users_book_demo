package com.example.prographyquest_ahnhyoungjin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.prographyquest_ahnhyoungjin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get data from intent
        var name = intent.getStringExtra("name")
        var profile = intent.getStringExtra("profile")
        var html = intent.getStringExtra("html")
        var repos = intent.getStringExtra("repos")
        var type = intent.getStringExtra("type")

        // data set in layout
        binding.txName.text = "name: "+name.toString()

        binding.imgProfile.setImageURI(profile?.toUri())
        Glide.with(this).load(profile).into(binding.imgProfile)

        binding.txType.text = "type: "+type.toString()

        // github button onClickListener. Hyperlink
        binding.btnHtml.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(html))
            startActivity(intent)
        }

        // followers button onClickListener
        binding.btnRepos.setOnClickListener {
            var intent = Intent(this, FollowersActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("followers", repos)
            startActivity(intent)
        }
    }
}