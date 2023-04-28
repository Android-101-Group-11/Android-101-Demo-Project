package com.example.carbonator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class CarAdapter(private val carListPost: MutableList<MainActivity.carInfoPost>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val make : TextView
        val model : TextView
        val year : TextView
        val emission: TextView

        init {
            make = view.findViewById(R.id.car_make)
            model = view.findViewById(R.id.car_model)
            year = view.findViewById(R.id.car_year)
            emission = view.findViewById(R.id.car_emission)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_items, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val pokeNameText = holder.pokeName
        //val pokemonNameFetch = pokeList[position].second
        //pokeNameText.text = pokeList[position].second

//        holder.pokeImage.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "You tapped on $pokemonNameFetch! ", Toast.LENGTH_SHORT).show()
//        }

        val carMakeText = holder.make
        carMakeText.text = carListPost[position].postmake
        val carModelText = holder.model
        carModelText.text = carListPost[position].postmodel
        val carYearText = holder.year
        carYearText.text = carListPost[position].postyear
        val carEmissionText = holder.emission
        carEmissionText.text = carListPost[position].postemission


    }

    override fun getItemCount() = carListPost.size






}