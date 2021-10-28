package com.andrei.firstfirebase.activities.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.andrei.firstfirebase.Beer
import com.andrei.firstfirebase.BeerListActivity
import com.andrei.firstfirebase.BeerListPresentor
import com.andrei.firstfirebase.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var mDataBase: DatabaseReference
    private val USER_KEY: String = "User"
    private lateinit var beer: Beer
    private lateinit var beerName: String
    private lateinit var breweryName: String
    private lateinit var litres: String
    private lateinit var beerListPresentor: BeerListPresentor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Поток", "Мэйнактивити: " + Thread.currentThread().name)
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            initTextViews()
            val id: String? = mDataBase.key
            beer = Beer(id, beerName, breweryName, litres)
            beerListPresentor = BeerListPresentor()
            beerListPresentor.insertIntoDB(beer)

        }
        findViewById<Button>(R.id.loadButton).setOnClickListener {
            intent = Intent(this@MainActivity, BeerListActivity::class.java)
            startActivity(intent)
        }

    }

    fun initTextViews() {
        beerName = findViewById<EditText>(R.id.editTextBeerName).text.toString()
        breweryName = findViewById<EditText>(R.id.editTextBreweryName).text.toString()
        litres = findViewById<EditText>(R.id.editTextLitres).text.toString()
    }

}