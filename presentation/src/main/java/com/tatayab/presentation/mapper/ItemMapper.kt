package com.tatayab.presentation.mapper

import com.tatayab.model.*
import javax.inject.Inject

class ItemMapper @Inject constructor() : PresentationMapper<MapValueXXX, ProductPaging> {


    override fun mapToEntity(domain: ProductPaging): MapValueXXX {
        return with(domain) {
            MapValueXXX(
                productCode = product_code,
                amAges = "",
                freeShipping = is_free_delivery,
                product = product,
                price = price,
                amount = amount,
                availableAmount = availableAmount,
                productId = product_id.toString(),
                maxQty = max_qty,
                minQty = min_qty,
                productOptions = getOptions(cached_product_options),
                productOptionsDetailed = cached_product_options,
                basePrice = base_price?.toDouble(),
                basePriceFormatted = BasePriceFormatted(price.toString(), "w"),
                mainPair = main_pair!!,
                supplierName = supplier_name,
                supplierId = supplier_id,
                list_price = list_price?.toDouble()
            )
        }
    }

    private fun getOptions(map: Map<String, ProductOptionsDetailed>?): Map<String, String> {
        val resultMap = mutableMapOf<String, String>()
        map?.forEach {
            resultMap[it.key] = it.value.variants?.values?.first()?.variant_id!!
        }
        return resultMap
    }

    private fun getDetailsOptions(map: Map<String, Variant>?): Map<String, ProductOptionsDetailed> {
        val resultMap = mutableMapOf<String, ProductOptionsDetailed>()
        map?.forEach {
            resultMap[it.key] =
                ProductOptionsDetailed(variants = mapOf<Int, Variant>(it.key.toInt() to it.value))
        }
        return resultMap
    }
}