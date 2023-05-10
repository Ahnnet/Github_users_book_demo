package com.example.prographyquest_ahnhyoungjin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prographyquest_ahnhyoungjin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object{
        var BaseUrl = "https://api.github.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // data load
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitInterface::class.java)
        retrofitService.requestAllData().enqueue(object : Callback<List<DataModel>>{
            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                // data load success
                if(response.isSuccessful) {
                    var body = response.body()!!
                    // adapter
                    setAdapter(body)
                }
                // data connection fail
                else{
                    Log.d("retrofit", response.code().toString())
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