package com.example.contacts

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contacts.R

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

    val contList = getcont()

    val itemsAdapter = ContAdapter(this,contList)

        listView.adapter = itemsAdapter

    listView.onItemClickListener =
        AdapterView.OnItemClickListener { parent, view, position, id ->
            val contname = contList[position].nombre
            val telefono = contList[position].telefono
            Toast.makeText(
                applicationContext,
                "$contname tiene el teléfono $telefono", Toast.LENGTH_SHORT
            )
                .show()
        }
}


private fun getcont(): ArrayList<ConttModel>{
    val contModels = arrayListOf(
        ConttModel("Ana","5545925125", "ana@gmail.com ",R.drawable.ana),
        ConttModel("Alan","5611278692", "alan@outlook.com",R.drawable.alan),
        ConttModel("Daniel","5513145127", "Everyone@outlook.com",R.drawable.daniel),
        ConttModel("Jonathan","5542869754", "jonathan@yahoo.com",R.drawable.jonathan),
        ConttModel("Rodrigo","5588796842","onliyou@gmail.com",R.drawable.rodrigo),
        ConttModel("Sandra","5687412978", "everyone@gmail.com",R.drawable.sandra)
    )

    return contModels
}

}