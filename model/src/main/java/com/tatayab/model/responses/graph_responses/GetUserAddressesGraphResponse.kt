package com.tatayab.model.responses.graph_responses

class GetUserAddressesGraphResponse(val data: GraphData) : BaseGrapgQlResponse()

data class GraphData(
    val customer: GraphCustomerData?
)

data class GraphCustomerData(
    val firstname: String?,
    val lastname: String?,
    val email: String?,
    val addresses: List<GraphCustomerAddress>?=null
)

data class GraphCustomerAddress(
    val id: Int?=0,
    val city_id: Int?=0,
    val firstname: String?="",
    val lastname: String?="",
    val city: String?="",
    val postcode: String?="",
    val country_code: String?="",
    val telephone: String?="",
    val block: String?="",
    val house_building: String?="",
    val street_add: String?="", // present address
    val add_direction: String?="", // present extra info
    val addr_type: String?="",
    val street: List<String>?=null,// present address name
    val region: GraphUserRegion?=null,
    val default_shipping : Boolean,
    val default_billing : Boolean,
    val keep_secret :Boolean
)

class GraphUserRegion(
    val region_code: String?="",
    val region_id: Int?=0,
    val region: String?=""
)
