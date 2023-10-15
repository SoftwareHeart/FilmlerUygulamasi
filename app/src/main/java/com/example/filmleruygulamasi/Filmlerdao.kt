package com.example.filmleruygulamasi

class Filmlerdao {

    fun tumFilmlerByKategoriId(vt:VeritabaniYardimcisi,kategori_id:Int):ArrayList<Filmler>
    {
        val db=vt.writableDatabase

        val filmlerlerListe = ArrayList<Filmler>()

        val c = db.rawQuery("SELECT * FROM kategoriler,yonetmenler,filmler where filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_id",null)
        while (c.moveToNext())
        {
            val kategori = Kategoriler(
                c.getInt(c.getColumnIndexOrThrow("kategori_id")),
                c.getString(c.getColumnIndexOrThrow("kategori_ad"))
            )
            val yonetmen = Yonetmenler(
                c.getInt(c.getColumnIndexOrThrow("yonetmen_id")),
                c.getString(c.getColumnIndexOrThrow("yonetmen_ad"))
            )
            val film=Filmler(
                c.getInt(c.getColumnIndexOrThrow("film_id")),
                c.getString(c.getColumnIndexOrThrow("film_ad")),
                c.getInt(c.getColumnIndexOrThrow("film_yil")),
                c.getString(c.getColumnIndexOrThrow("film_resim")),
                kategori,yonetmen
            )
            filmlerlerListe.add(film)
        }
        return filmlerlerListe
    }

}