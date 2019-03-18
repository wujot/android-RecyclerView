package com.hemmersbach.android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.hemmersbach.android.model.Person
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.card_layout.view.*

class CustomAdapter(val personList: ArrayList<Person>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var onItemSelectedListener: ((Person) -> Unit)? = null

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {

        val person = personList[position]

        Picasso.get()
            .load(person.imageUrl)
            .fit().centerCrop()
            .into(p0.image)

        p0.rating.rating = person.rating.toFloat()
        p0.name.text = person.name
        p0.address.text = person.address
        p0.phone.text = person.phone
        p0.email.text = person.email
        p0.itemView.setOnClickListener{
            onItemSelectedListener?.invoke(person)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.card_layout, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var image = itemView.image
        var rating = itemView.ratings
        val name = itemView.name
        val address = itemView.address
        val phone = itemView.phone
        val email = itemView.email
    }
}
