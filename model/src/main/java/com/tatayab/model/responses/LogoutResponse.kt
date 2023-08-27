package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class LogoutResponse(@SerializedName("status") val status :Int , @SerializedName("data") val mLogoutModel: LogoutModel ) {
}
/*"{
""status"": 1,
""data"": {
    ""msg"": success
}
}"*/

