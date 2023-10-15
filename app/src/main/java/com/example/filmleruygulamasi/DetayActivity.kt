package com.example.filmleruygulamasi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewFilmAd.text = film.film_ad
        binding.textViewFilmYil.text=film.film_yil.toString()
        binding.textViewYonetmen.text=film.yonetmen.yonetmen_ad
        binding.imageViewResim.setImageResource(resources.getIdentifier(film.film_resim,
        "drawable",packageName))

    }

}