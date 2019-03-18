package com.hemmersbach.android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hemmersbach.android.model.Person
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get Person from previous activity
        val person: Person = intent.getParcelableExtra("person")
        assignData(person)
    }

    private fun assignData(person: Person) {
        setTitle(person.name)
        Picasso.get().load(person.imageUrl).into(card_detail_image)
        card_detail_name.text = person.name
        card_detail_ratings.rating = person.rating.toFloat()
        card_detail_address.text = person.address
        card_detail_phone.text = person.phone
        card_detail_email.text = person.email
    }
}
