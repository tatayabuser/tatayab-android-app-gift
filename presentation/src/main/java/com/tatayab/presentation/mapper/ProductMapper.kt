package com.tatayab.presentation.mapper

import com.tatayab.model.BasePriceFormatted
import com.tatayab.model.MapValueXXX
import com.tatayab.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() : PresentationMapper<MapValueXXX, Product> {


    override fun mapToEntity(domain: Product): MapValueXXX {
        return with(domain) {
            MapValueXXX(
                freeShipping=is_free_delivery,
                productCode=product_code,
                amAges = "",
                product = product,
                price = price,
                amount = amount,
                availableAmount = availableAmount?.toInt(),
                productId = product_id.toString(),
                minQty = min_qty,
                productOptions = hashMapOf(),
                basePrice = base_price?.toDouble(),
                basePriceFormatted = BasePriceFormatted(price.toString(), "w"),
                mainPair = main_pair!!,
                list_price = list_price?.toDouble()
            )
        }
    }
}