package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class UserTokenResponse(@SerializedName("status") val status :Int ,@SerializedName("msg") val errorMessage:String="" , @SerializedName("data") val mFirstTokenModel: FirstTokenModel ) {
}
/*{
    "status": 1,
    "data": {
        "token": "TATAYAB::a6216957f76dd3637ab609001d9c0166"
    }
}*/