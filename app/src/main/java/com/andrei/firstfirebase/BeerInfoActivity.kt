package com.andrei.firstfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class BeerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_info)

        val beerName = intent.getStringExtra(CustomViewHolder.BEER_NAME_KEY)
        val breweryName = intent.getStringExtra(CustomViewHolder.FREWERY_NAME_KEY)
        val litres = intent.getStringExtra(CustomViewHolder.LITRE_KEY)

        supportActionBar?.title = beerName
        findViewById<TextView>(R.id.textView_beerName1).text = beerName
        findViewById<TextView>(R.id.textView_breweryName1).text = breweryName
        findViewById<TextView>(R.id.textView_litres1).text = litres

//        textView_.text = name
//        textView_premiere.text = premiere
//        textView_description.text = description
//        Picasso.with(this).load(link).error(R.drawable.ic_launcher_foreground).into(imageView_poster)
//        setTitle()
    }
}