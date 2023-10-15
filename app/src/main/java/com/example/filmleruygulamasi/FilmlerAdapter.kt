package com.example.filmleruygulamasi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext:Context,private val filmlerListe:List<Filmler>):
RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim: View):RecyclerView.ViewHolder(tasarim)
    {
        var film_Card:CardView
        var imageViewFilmResim:ImageView
        var textViewFilmAd:TextView

        init {
            film_Card=tasarim.findViewById(R.id.film_card)
            imageViewFilmResim=tasarim.findViewById(R.id.imageViewFilmResim)
            textViewFilmAd=tasarim.findViewById(R.id.textViewFilmAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListe[position]

        holder.textViewFilmAd.text=film.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim,
            "drawable",mContext.packageName))

        holder.film_Card.setOnClickListener{

            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)

        }

    }

}