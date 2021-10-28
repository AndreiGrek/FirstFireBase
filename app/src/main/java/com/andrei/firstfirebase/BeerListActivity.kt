package com.andrei.firstfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class BeerListActivity : AppCompatActivity() {

    lateinit var beerListAdapter: BeerListAdapter
    private lateinit var mDataBase: DatabaseReference
    private val USER_KEY: String = "User"
    lateinit var beer: Beer
    var beerList = mutableListOf<Beer>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_list)
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY)
         getFromDB()

        findViewById<RecyclerView>(R.id.recyclerView_list).layoutManager = LinearLayoutManager(this)
        beerListAdapter = BeerListAdapter(this, beerList)
//        beerListAdapter.notifyDataSetChanged()
        findViewById<RecyclerView>(R.id.recyclerView_list).adapter = beerListAdapter
    }

    fun getFromDB() {
       mDataBase.addValueEventListener(object :ValueEventListener{
           override fun onDataChange(p0: DataSnapshot) {
               if(beerList.size > 0){
                   beerList.clear()
               }
                p0.children.forEach{
                    beer = it.getValue (Beer:: class.java)!!
//                    beer = Beer("wfe0", "ИМЯ", "wfe0", "wfe0" )
                    beerList.add(beer)
                }
               beerListAdapter.notifyDataSetChanged()


               Log.d("TAG", "сработала загрузка")
               Log.d("TAGGGG", beer.beerName)
           }

           override fun onCancelled(p0: DatabaseError) {

           }

       })
    }
}