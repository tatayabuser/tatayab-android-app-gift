package com.tatayab.model.responses

import android.os.Parcelable

data class ContactNumberPerCountryModel(
    val country: String?,
    val phoneNumbers:ArrayList<String>?

)

/*
* [
  {
    "country": "KW",
    "phoneNumbers": [
      "+96599991181",
      "+96592294835"
    ]
  },
  {
    "country": "SA",
    "phoneNumbers": [
      "+96599991181",
      "+96592294835"
    ]
  }
]
* */