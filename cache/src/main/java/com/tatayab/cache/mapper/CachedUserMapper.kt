package com.tatayab.cache.mapper

import com.tatayab.cache.model.CachedAddress
import com.tatayab.cache.model.CachedUser
import com.tatayab.model.UserProfile
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.responses.AuthenticationResponse
import javax.inject.Inject

class CachedUserMapper @Inject constructor() : CacheMapper<CachedUser, AuthenticationResponse> {

    //TODO implement this
    override fun mapFromCached(type: CachedUser): AuthenticationResponse {
        throw NotImplementedError("categories  isn't supported here...")
        /*return with(type) {
            UserProfile()
        }*/
    }

    override fun mapToCached(type: AuthenticationResponse): CachedUser {
        return with(type) {
            CachedUser(user_id.toString()!!, firstname!!," lastname!!")

        }
    }
}
