package com.example.coronaapp.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CountryInfo {
    @SerializedName("_id")
    @Expose
    var id: Int? = null

    @SerializedName("iso2")
    @Expose
    var iso2: String? = null

    @SerializedName("iso3")
    @Expose
    var iso3: String? = null

    @SerializedName("lat")
    @Expose
    var lat: Float =0.0f

    @SerializedName("long")
    @Expose
    var _long: Float =0.0f

    @SerializedName("flag")
    @Expose
    var flag: String? = null
}
class AllCountries {
    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("countryInfo")
    @Expose
    var countryInfo: CountryInfo? = null

    @SerializedName("updated")
    @Expose
    var updated: Float =0.0f

    @SerializedName("cases")
    @Expose
    var cases: Float =0.0f

    @SerializedName("todayCases")
    @Expose
    var todayCases: Float =0.0f

    @SerializedName("deaths")
    @Expose
    var deaths: Float =0.0f

    @SerializedName("todayDeaths")
    @Expose
    var todayDeaths: Float =0.0f

    @SerializedName("recovered")
    @Expose
    var recovered: Float =0.0f

    @SerializedName("active")
    @Expose
    var active: Float =0.0f

    @SerializedName("critical")
    @Expose
    var critical: Float =0.0f

    @SerializedName("casesPerOneMillion")
    @Expose
    var casesPerOneMillion: Float =0.0f

    @SerializedName("deathsPerOneMillion")
    @Expose
    var deathsPerOneMillion: Float =0.0f

    @SerializedName("tests")
    @Expose
    var tests: Float =0.0f

    @SerializedName("testsPerOneMillion")
    @Expose
    var testsPerOneMillion: Float =0.0f
}
//
//class CountryInfo {
//    @Json(name = "_id")
//    var id: Double= 0.0
//
//    @Json(name = "iso2")
//    var iso2: String? = ""
//
//    @Json(name = "iso3")
//    var iso3: String? = ""
//
//    @Json(name = "lat")
//    var lat: Float = 0.0f
//
//    @Json(name = "long")
//    var _long: Float = 0.0f
//
//    @Json(name = "flag")
//    var flag: String? = ""
//}
//
//class AllCountries (
//    @Json(name = "country")
//    var country: String? = "",
//
//    @Json(name = "countryInfo")
//    var countryInfo: CountryInfo? = null,
//
//    @Json(name = "updated")
//    var  updated: Float = 0.0f,
//
//    @Json(name = "cases")
//    var cases: Float = 0.0f,
//
//    @Json(name = "todayCases")
//    var todayCases: Float = 0.0f,
//
//    @Json(name = "deaths")
//    var deaths: Float = 0.0f,
//
//    @Json(name = "todayDeaths")
//    var todayDeaths: Float = 0.0f,
//
//    @Json(name = "recovered")
//    var recovered: Float = 0.0f,
//
//    @Json(name = "active")
//    var active: Float = 0.0f,
//
//    @Json(name = "critical")
//    var critical: Float = 0.0f,
//
//    @Json(name = "casesPerOneMillion")
//    var casesPerOneMillion: Float = 0.0f,
//
//    @Json(name = "deathsPerOneMillion")
//    var deathsPerOneMillion: Float = 0.0f,
//
//    @Json(name = "tests")
//    var tests: Float = 0.0f,
//
//    @Json(name = "testsPerOneMillion")
//    var testsPerOneMillion: Float = 0.0f
//)