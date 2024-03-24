package com.example.app_todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_todo.databinding.ActivityTodoListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TodoList : AppCompatActivity() {

       private lateinit var newRecyclerView: RecyclerView
       private lateinit var newArrayList: ArrayList<Todos>

    private lateinit var imageId : Array<Int>
    private lateinit var heading:Array<String>

    private lateinit var binding: ActivityTodoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityTodoListBinding.inflate(layoutInflater)



        setContentView(binding.root)

        imageId = arrayOf(R.drawable.a,R.drawable.b)

        heading = arrayOf("work shop","meeting")

        newRecyclerView = findViewById<RecyclerView>(R.id.recycleView) // ปรับเปลี่ยนชื่อตัวแปรจาก newRecylerView เป็น newRecyclerView และเพิ่มประเภทของตัวแปรเป็น RecyclerView
        newRecyclerView.layoutManager = LinearLayoutManager(this) // ใช้ LinearLayoutManager ในการจัดการแสดงรายการของ RecyclerView
        newRecyclerView.setHasFixedSize(true) // กำหนดให้ RecyclerView มีขนาดคงที่

        newArrayList = arrayListOf<Todos>()
        getUserdata()

        val buttonRegiaster = findViewById<Button>(R.id.newTodoBtn)

        buttonRegiaster.setOnClickListener {

            val intent = Intent(this,newTodo::class.java)
            startActivity(intent)
        }



    }




    private fun getUserdata() {


       for (i in imageId.indices){
           val news = Todos(imageId[i],heading[i])
           newArrayList.add(news)
       }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }



}