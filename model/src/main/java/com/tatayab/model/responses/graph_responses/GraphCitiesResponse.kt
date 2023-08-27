package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class GraphGetCitiesResponse(val data: GraphGetCities)
data class GraphGetCities(val getCities: GraphCitiesResponse)
data class GraphCitiesResponse(val cities: List<GraphCity>)

data class GraphCity(val city_id: Int, val default_name: String, val locale_name: String)
//{"city_id":1442,"default_name":"Abdally","locale_name":"Abdally"}

class GraphGetRegionsResponse(val data: GraphGetRegions)
data class GraphGetRegions(@SerializedName("country") val mGraphRegionsResponse: GraphRegionsResponse)
data class GraphRegionsResponse(
    val id: String,
    @SerializedName("available_regions") val available_regions: List<GraphRegion>
)

@Parcelize
data class GraphRegion(val id: Int, val code: String, val name: String) : Parcelable


