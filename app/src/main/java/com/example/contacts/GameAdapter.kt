package com.example.contacts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.contacts.R

class ContAdapter(private val context: Context,
                  private val datos: ArrayList<ConttModel>
): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    //Infla una vista para un Item de la lista, aquí se describe cómo se va a desplegar la info
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //inflamos la vista item_game para cada elemento de la lista
        val contacto = inflater.inflate(R.layout.item_game, parent, false)

        //obtenemos las referencias de cada View de nuestro layout de item_game
        val tvNombre = contacto.findViewById<View>(R.id.tvNombre) as TextView
        val tvNumero = contacto.findViewById<View>(R.id.tvNumero) as TextView
        val tvEmail = contacto.findViewById<View>(R.id.tvEmail) as TextView
        val imagenid = contacto.findViewById<View>(R.id.imagenid) as ImageView

        //obtenemos la información del item por medio de getItem()
        val cont = getItem(position) as ConttModel

        //seteamos todos los valores a nuestras vistas para desplegar la información
        tvNombre.text = cont.nombre
        tvNumero.text = cont.telefono
        tvEmail.text = cont.email
        imagenid.setImageResource(cont.imagenid)

        return contacto
    }


    //regresa un item para ser colocado en la posición position del Listview
    override fun getItem(position: Int): Any {
        return datos[position]
    }

    //Este método define un id para cada item, decidimos usar el index en el array de data
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //este método le dice al ListView cuantos items mostrar
    override fun getCount(): Int {
        return datos.size
    }
}