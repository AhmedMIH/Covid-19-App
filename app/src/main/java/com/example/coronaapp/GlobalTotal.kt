package com.example.coronaapp

import com.squareup.moshi.Json
data class GlobalTotal (
    @Json(name = "updated")
    var updated: Float = 0.0f,

    @Json(name = "cases")
    var cases: Float = 0.0f,

    @Json(name = "todayCases")
    var todayCases: Float = 0.0f,

    @Json(name = "deaths")
    var deaths: Float = 0.0f,

    @Json(name = "todayDeaths")
    var todayDeaths: Float = 0.0f,

    @Json(name = "recovered")
    var recovered: Float = 0.0f,

    @Json(name = "active")
    var active: Float = 0.0f,

    @Json(name = "critical")
    var critical: Float = 0.0f,

    @Json(name = "casesPerOneMillion")
    var casesPerOneMillion: Float = 0.0f,

    @Json(name = "deathsPerOneMillion")
    var deathsPerOneMillion: Float = 0.0f,

    @Json(name = "tests")
    var tests: Float = 0.0f,

    @Json(name = "testsPerOneMillion")
    var testsPerOneMillion: Float = 0.0f,

    @Json(name = "affectedCountries")
    var affectedCountries: Float = 0.0f
)