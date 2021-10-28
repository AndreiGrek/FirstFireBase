package com.andrei.firstfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var mDataBase: DatabaseReference
    private val USER_KEY: String = "User"
    lateinit var beer: Beer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY)
        findViewById<Button>(R.id.saveButton).setOnClickListener{
            val id: String? = mDataBase.key
            val beerName =  findViewById<EditText>(R.id.editTextBeerName).text.toString()
            val breweryName =  findViewById<EditText>(R.id.editTextBreweryName).text.toString()
            val litres =  findViewById<EditText>(R.id.editTextLitres).text.toString()
            Log.d("TAG", beerName )
            Log.d("TAG", breweryName )
            Log.d("TAG", litres )
            beer = Beer(id, beerName, breweryName, litres)
//            Log.d("TAG", beer. )
            mDataBase.push().setValue(beer)

        }
        findViewById<Button>(R.id.loadButton).setOnClickListener{
            intent = Intent (this@MainActivity, BeerListActivity:: class.java )
            startActivity(intent)
        }

    }

}