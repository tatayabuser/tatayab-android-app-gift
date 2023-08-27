package com.tatayab.cache.mapper

import com.tatayab.cache.model.CachedWishItem
import com.tatayab.model.db.WishItem
import javax.inject.Inject

class CachedWishItemMapper @Inject constructor() : CacheMapper<CachedWishItem, WishItem> {

    override fun mapFromCached(type: CachedWishItem): WishItem {
        return with(type) {
            WishItem(
                userId,
                produectId,
                countryId
            )
        }
    }

    override fun mapToCached(type: WishItem): CachedWishItem {
        return with(type) {
            CachedWishItem(
                  userId = userId,
                produectId = produectId,
                countryId = countryId
            )
        }
    }
}
