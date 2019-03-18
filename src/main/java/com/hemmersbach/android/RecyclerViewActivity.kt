package com.hemmersbach.android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hemmersbach.android.model.Person
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.io.InputStream

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val fileName = "data.json"
        val data = getData(fileName)
        val adapter = assignDataToRecyclerView(data)
        setOnPersonClickListener(adapter)
    }

    private fun getData(fileName: String): ArrayList<Person> {
        val database: InputStream = assets.open(fileName)
        val json = database.toJsonString()
        val gson: Gson = GsonBuilder().create()
        val data = gson.fromJson(json, Array<Person>::class.java)
        val dataCollection = data.toCollection(ArrayList())
        return dataCollection
    }

    private fun assignDataToRecyclerView(data: ArrayList<Person>): CustomAdapter {
        //recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter = CustomAdapter(data)
        recycler_view.adapter = adapter
        return adapter
    }

    private fun sendPersonToNextStep(data: Person) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("person", data)
        startActivity(intent)
    }

    private fun setOnPersonClickListener(adapter: CustomAdapter) {
        adapter.onItemSelectedListener = { person ->
            sendPersonToNextStep(person)
        }
    }

/*
    private fun setOnPersonClickListener(adapter: CustomAdapter, data: ArrayList<Person>) {
        adapter.onItemSelectedListener = { index ->
            sendPersonToNextStep(data[index])
        }
    }
    */
}
