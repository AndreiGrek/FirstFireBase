package com.andrei.firstfirebase

import android.content.Context
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
    }
}

class CustomViewHolder(val view: View, var beer: Beer? = null) : RecyclerView.ViewHolder(view) {

    companion object {
        val FILM_NAME_KEY = "FILM_NAME"
        val FILM_NAMEENG_KEY = "FILM_NAMEENG"
        val FILM_PREMIERE_KEY = "FILM_PREMIERE"
        val FILM_DESCRIPTION_KEY = "FILM_DESCRIPTION"
        val FILM_LINK_KEY = "FILM_LINK"
    }

    init {
        view.setOnClickListener {
//            val intentToInfoActivity = Intent(view.context, FilmInfoActivity::class.java)
//
//            intentToInfoActivity.putExtra(FILM_NAMEENG_KEY, film?.name_eng)
//            intentToInfoActivity.putExtra(FILM_NAME_KEY, film?.name)
//            intentToInfoActivity.putExtra(FILM_DESCRIPTION_KEY, film?.description)
//            intentToInfoActivity.putExtra(FILM_PREMIERE_KEY, film?.premiere)
//            intentToInfoActivity.putExtra(FILM_LINK_KEY, film?.image)
//            view.context.startActivity(intentToInfoActivity)
        }
    }
}