package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class GetLayoutBlocks(@SerializedName("data") val blocksData: BlocksDate) : BaseGrapgQlResponse()

class BlocksDate(@SerializedName("MobileLayoutGraphql") val mobileLayoutGraphql: MobileLayoutGraphql)

class MobileLayoutGraphql(@SerializedName("blocks") val graphBlocks: List<GraphBlock>)

class GraphBlock(
    val block_id: String,
    val position: Int,
    val catId: Int,
    val type: String,
    val title: String,
    val subtitle: String,
    val name: String,
    val template: String,
    val ob_ids: String
)
