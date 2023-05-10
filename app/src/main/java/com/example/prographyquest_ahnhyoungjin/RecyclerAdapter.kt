package com.example.prographyquest_ahnhyoungjin

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.properties.Delegates

class RecyclerAdapter(val datas:List<DataModel>, val context:Context)
    :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        private val txt_name: TextView = itemView.findViewById(R.id.tx_name)
        private val image_profile: ImageView = itemView.findViewById(R.id.img_profile)
        private val txt_id: TextView = itemView.findViewById(R.id.id)

        fun bind(item: DataModel){
            txt_name.text = item.login
            Glide.with(itemView).load(item.avatar_url.toUri()).into(image_profile)
            txt_id.text = item.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.data_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        var dataNum = datas.size
        return dataNum
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

        // recyclerView onClickListener
        // start DetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("name", datas[position].login)
            intent.putExtra("profile", datas[position].avatar_url)
            intent.putExtra("html", datas[position].html_url)
            intent.putExtra("repos", datas[position].followers_url)
            intent.putExtra("type", datas[position].type)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

}