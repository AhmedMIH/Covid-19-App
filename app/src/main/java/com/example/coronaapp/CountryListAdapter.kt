package com.example.coronaapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CountryListAdapter(var context: Context,var countryList: List<AllCountries>) :
    RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.recycler_view_item, parent, false)
            return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.onBind(context,countryList[position])
    }
}

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(context: Context,country: AllCountries) {
        val name = itemView.findViewById<TextView>(R.id.CountyName)
        name.text= country.country
        val case = itemView.findViewById<TextView>(R.id.CaseNumber)
        case.text = country.cases.toString()

        name.setOnClickListener {
            onClick(context,country)
        }
        case.setOnClickListener {
            onClick(context, country)
        }
    }

    private fun onClick(
        context: Context,
        country: AllCountries
    ) {
        val countryDetails :ArrayList<String> = ArrayList()
        countryDetails.add(country.country!!)
        countryDetails.add(country.cases.toString())
        countryDetails.add(country.active.toString())
        countryDetails.add(country.deaths.toString())
        countryDetails.add(country.recovered.toString())
        countryDetails.add(country.todayCases.toString())
        countryDetails.add(country.todayDeaths.toString())
        countryDetails.add(country.tests.toString())
        countryDetails.add(country.critical.toString())


        val i =Intent(context,CountryDetailsActivity::class.java)
        i.putExtra("CountryDetails",countryDetails)
        context.startActivity(i)
    }
}

