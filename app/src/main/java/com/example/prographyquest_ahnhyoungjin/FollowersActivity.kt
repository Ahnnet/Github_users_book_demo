package com.example.prographyquest_ahnhyoungjin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prographyquest_ahnhyoungjin.databinding.ActivityFollowersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FollowersActivity : AppCompatActivity() {

    lateinit var binding: ActivityFollowersBinding

    companion object{
        var BaseUrl = "https://api.github.com/users"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // data load
        var name = intent.getStringExtra("name")
        val FollowersUrl = BaseUrl + "/" +name.toString() +"/"

        val retrofit = Retrofit.Builder()
            .baseUrl(FollowersUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitFollowerInterface::class.java)
        retrofitService.requestAllData().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                // data load success
                if(response.isSuccessful) {
                    var body = response.body()!!
                    // set adapter
                    setAdapter(body)
                }
                // data connection fail
                else{
                    Log.d("retrofit",response.code().toString())
                }
            }
            // data load fail
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                Log.d("retrofit", t.message.toString())
            }
        })
    }

    // recyclerView adapter
    private fun setAdapter(dataList: List<DataModel>){
        val mAdapter = RecyclerAdapter(dataList,this)

        binding.rv1.adapter = mAdapter
        val gridLayoutManager = GridLayoutManager(applicationContext,3)
        binding.rv1.layoutManager = gridLayoutManager
    }
}