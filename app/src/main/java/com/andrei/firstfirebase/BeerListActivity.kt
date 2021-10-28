package com.andrei.firstfirebase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BeerListActivity : AppCompatActivity(), PresentorView {

    lateinit var beerListAdapter: BeerListAdapter
    lateinit var beerListPresentor: BeerListPresentor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_list)
        Log.d("Поток", "БирЛист: " + Thread.currentThread().name)
        beerListPresentor = BeerListPresentor(this)

        findViewById<RecyclerView>(R.id.recyclerView_list).layoutManager = LinearLayoutManager(this)
        beerListPresentor.getFromDB()
    }

    override fun showData(beerList: MutableList<Beer>) {
        beerListAdapter = BeerListAdapter(this, beerList)
        beerListAdapter.notifyDataSetChanged()
        findViewById<RecyclerView>(R.id.recyclerView_list).adapter = beerListAdapter
    }
}