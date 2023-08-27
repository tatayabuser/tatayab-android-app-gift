package com.tatayab.model.responses

import com.tatayab.model.responses.graph_responses.GraphProductSpecificationsEnum

data class ProductSpecific(
    val label: String?=null,
    val value: String?=null,
    val productSpecificType : GraphProductSpecificationsEnum?=null
)