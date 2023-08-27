package com.tatayab.cache.mapper

import com.tatayab.cache.model.CachedAddress
import com.tatayab.model.db.CustomerAddress
import javax.inject.Inject

class CachedAddressMapper @Inject constructor() : CacheMapper<CachedAddress, CustomerAddress> {

    override fun mapFromCached(type: CachedAddress): CustomerAddress {
        return with(type) {
            CustomerAddress(
                addressId,
                userId,
                title,
                shippingAddress,
                billingAddress,
                city,
                country,
                zipCode,
                isPrimary
            )
        }
    }

    override fun mapToCached(type: CustomerAddress): CachedAddress {
        return with(type) {
            CachedAddress(
                addressId = addressId,
                userId = userId,
                title = title,
                shippingAddress = shippingAddress,
                billingAddress = billingAddress,
                city = city,
                country = country,
                zipCode = zipCode,
                isPrimary = isPrimary
            )
        }
    }
}
