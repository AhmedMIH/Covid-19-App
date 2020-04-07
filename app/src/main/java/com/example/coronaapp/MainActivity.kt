package com.example.coronaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel by lazy {
            ViewModelProvider(this).get(MainViewModel::class.java)
        }
        viewModel.response.observe(this, Observer {
            createPieChart(it)
        })
        viewModel.countries.observe(this, Observer {
            createListCountry(it)
        })

    }

    private fun createPieChart(GlobalTotal:GlobalTotal){
        val pieData: MutableList<PieEntry> = ArrayList()
        pieData.add(PieEntry(GlobalTotal.active,"active", 0))
        pieData.add(PieEntry(GlobalTotal.recovered,"Recovered",1))
        pieData.add(PieEntry(GlobalTotal.deaths,"deaths",2))
        val dataSet = PieDataSet(pieData,"No of Cases")
        dataSet.colors =ColorTemplate.createColors(ColorTemplate.COLORFUL_COLORS)
        val data = PieData(dataSet)
        piaChart_all.data = data
        piaChart_all.animateXY(5000,5000)
    }
    private fun createListCountry (CountryList: List<AllCountries>){
        Country_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL
            ,false)
        val adapter = CountryListAdapter(this,CountryList)
        Country_list.adapter=adapter
    }
}
