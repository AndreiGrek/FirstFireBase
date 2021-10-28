package com.andrei.firstfirebase

import android.util.Log
import com.google.firebase.database.*

class BeerListPresentor (var presentorView: PresentorView) {

    private lateinit var mDataBase: DatabaseReference
    private val USER_KEY: String = "User"
    lateinit var beer: Beer
    var beerList = mutableListOf<Beer>()


    fun getFromDB() {
        Log.d("Поток", "Начало презентора: " + Thread.currentThread().name)

        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY)
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                Log.d("Поток", "Середина презентора: " + Thread.currentThread().name)
                if(beerList.size > 0){
                    beerList.clear()
                }
                p0.children.forEach{
                    beer = it.getValue (Beer:: class.java)!!
                    beerList.add(beer)
                }

                Log.d("TAG", "сработала загрузка")
                Log.d("TAGGGG", beer.beerName)
                presentorView.showData(beerList)
                Log.d("Поток", "Конец презентора: " + Thread.currentThread().name)
            }

            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }

     fun insertIntoDB(beer: Beer){
         mDataBase.push().setValue(beer)
    }
}