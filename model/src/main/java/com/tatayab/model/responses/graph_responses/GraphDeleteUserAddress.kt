package com.tatayab.model.responses.graph_responses

data class GraphDeleteUserAddress (val data: GraphDeleteAddressData)

data class GraphDeleteAddressData (val deleteCustomerAddress : Boolean)
