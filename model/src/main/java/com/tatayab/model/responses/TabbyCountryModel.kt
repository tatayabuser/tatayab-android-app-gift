package com.tatayab.model.responses

import android.os.Parcelable

data class TabbyCountryModel(
    val country: String?,
    val content:ArrayList<CountryContentModel>?

){

}

class CountryContentModel(
    val title_en: String?,
    val subTitle_en: String?,
    val title_ar: String?,
    val subTitle_ar: String?,
    val image: String?,
    val seeMoreUrl_ar: String?,
    val seeMoreUrl_en: String?,
    val numberOfPayments: Int = 0
) {

}


/*[
  {
    "country": "SA",
    "content": [
      {
        "title_en": "Shop by installments",
        "subTitle_en": "بدون رسوم أو فوائد أو قسمها على *Y* دفعات شهرية بقيمة *X*",
        "title_ar": "تسوق بالتقسيط",
        "subTitle_ar": "بدون رسوم أو فوائد أو قسمها على *Y* دفعات شهرية بقيمة *X*",
        "image": "https://i.ibb.co/GMrxnK8/37c1gewR.jpg",
 "seeMoreUrl_ar": "https://checkout.tabby.ai/promos/product-page/installments/ar",
        "seeMoreUrl_en": "https://checkout.tabby.ai/promos/product-page/installments/en",
        "numberOfPayments": 4
              },
      {
        "title_en": "Shop now and pay later",
        "subTitle_en": "Pay after 14 days with tabby. No fees.",
        "title_ar": "اطلب الآن وادفع لاحقاً",
        "subTitle_ar": "ادفع بعد 14 يوم مع تابي. بدون رسوم",
        "image": "https://i.ibb.co/GMrxnK8/37c1gewR.jpg",
 "seeMoreUrl_ar": "https://checkout.tabby.ai/promos/product-page/installments/ar",
        "seeMoreUrl_en": "https://checkout.tabby.ai/promos/product-page/installments/en",
        "numberOfPayments": 4
      }
    ]
  },
  {
    "country": "AE"
  }
]*/
