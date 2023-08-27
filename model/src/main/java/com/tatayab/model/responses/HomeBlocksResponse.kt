package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.Section

data class HomeBlocksResponse(
    @SerializedName("sections")
    val sections: List<Section>?=null
)