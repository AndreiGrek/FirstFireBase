package com.andrei.firstfirebase

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeerListAdapter(val context: Context, var beerList: MutableList<Beer>) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return beerList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.beer_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val beer = beerList.get(position)

        holder.itemView.findViewById<TextView>(R.id.textView_beerName).text = beer.beerName
        holder.itemView.findViewById<TextView>(R.id.textView_breweryName).text = beer.breweryName
        holder.itemView.findViewById<TextView>(R.id.textView_litres).text = beer.litres

        holder.beer = beer
    }
}

class CustomViewHolder(val view: View, var beer: Beer? = null ) : RecyclerView.ViewHolder(view) {

    companion object {
        val BEER_NAME_KEY = "BEER_NAME"
        val FREWERY_NAME_KEY = "FREWERY_NAME"
        val LITRE_KEY = "LITRE"
    }

    init {
        view.setOnClickListener {
            val intentToInfoActivity = Intent(view.context, BeerInfoActivity::class.java)
            Log.d("Tag22", (beer==null).toString())
            intentToInfoActivity.putExtra(BEER_NAME_KEY, beer?.beerName)
            intentToInfoActivity.putExtra(FREWERY_NAME_KEY, beer?.breweryName)
            intentToInfoActivity.putExtra(LITRE_KEY, beer?.litres)
//
            view.context.startActivity(intentToInfoActivity)
        }
    }
}