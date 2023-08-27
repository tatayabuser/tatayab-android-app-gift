package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

data class GetAddUserAddress(val data: CreateData) : BaseGrapgQlResponse()
data class CreateData(
    @SerializedName(
        "createCustomerAddress",
        alternate = ["updateCustomerAddress"]
    ) val createCustomerAddress: CreateCustomerAddress
)

data class CreateCustomerAddress(
    val id: Int?=0,
    val country_code: String?=""
)
