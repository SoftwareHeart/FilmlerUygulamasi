package com.example.filmleruygulamasi

import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter: KategoriAdapter
    private lateinit var vt :VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        veritabaniKopyala()


        binding.toolbarKategori.title="Filmler"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager=LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)

        kategoriListe=Kategorilerdao().tumKategoriler(vt)

        adapter=KategoriAdapter(this,kategoriListe)

        binding.kategoriRv.adapter=adapter

    }

    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}