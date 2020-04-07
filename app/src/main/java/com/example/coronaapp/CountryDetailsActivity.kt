package com.example.coronaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_country_details.*

class CountryDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val extras : Bundle = intent.extras!!
        val countryDetails = extras.getStringArrayList("CountryDetails")

        title= countryDetails!![0]

        CasesNumber.text= countryDetails[1]
        ActiveNumber.text=countryDetails[2]
        TotalDeathNumber.text=countryDetails[3]
        RecoveredNumber.text=countryDetails[4]
        TodayCasesNumber.text=countryDetails[5]
        TodayDeathNumber.text=countryDetails[6]
        TestNumber.text=countryDetails[7]
        CriticalNumber.text=countryDetails[8]

        val chartList : ArrayList<Float> = ArrayList()
        chartList.add(countryDetails[2].toFloat())
        chartList.add(countryDetails[3].toFloat())
        chartList.add(countryDetails[4].toFloat())
        createPieChart(chartList)

    }


    private fun createPieChart(countryDetails: ArrayList<Float>){
        val pieData: MutableList<PieEntry> = ArrayList()
        pieData.add(PieEntry(countryDetails[0],"active", 0))
        pieData.add(PieEntry(countryDetails[2],"Recovered",1))
        pieData.add(PieEntry(countryDetails[1],"deaths",2))
        val dataSet = PieDataSet(pieData,"No of Cases")
        dataSet.colors = ColorTemplate.createColors(ColorTemplate.COLORFUL_COLORS)
        val data = PieData(dataSet)
        CountyChart.data = data
        CountyChart.animateXY(5000,5000)
    }
}
