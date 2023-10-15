package com.example.filmleruygulamasi

class Kategorilerdao {
    fun tumKategoriler(vt:VeritabaniYardimcisi):ArrayList<Kategoriler>
    {
        val db=vt.writableDatabase

        val kategorilerListe = ArrayList<Kategoriler>()

        val c = db.rawQuery("Select * From kategoriler",null)
        while (c.moveToNext())
        {
            val kategori = Kategoriler(
                c.getInt(c.getColumnIndexOrThrow("kategori_id")),
                c.getString(c.getColumnIndexOrThrow("kategori_ad"))
            )
            kategorilerListe.add(kategori)
        }
        return kategorilerListe
    }
}