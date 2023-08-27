package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class UserProfileResponse (@SerializedName("data") val customerDataModel: CustomerDataModel):BaseGrapgQlResponse(){
class CustomerDataModel (@SerializedName("customer") val customerModel: CustomerModel?)

    class CustomerModel (@SerializedName("firstname") val firstname:String?="",
                         @SerializedName("lastname") val lastname:String?="",
                         @SerializedName("suffix") val suffix:String?="",
                         @SerializedName("gender") val gender:String?="",
                         @SerializedName("email") val email:String?="",
                          @SerializedName("country_code") val country_code:String?="",
                         @SerializedName("id") val id:String?="",
                         @SerializedName("wishlists") val wishlists:List<WishListData>?,
                         @SerializedName("phone_number") val phone_number:String?=""
    )
    data class WishListData (val id : String)
    }


/*{"data":{"customer":{"firstname":"Test","lastname":"User","suffix":null,"email":"corals@tatayab.com","id":null}}}
*/