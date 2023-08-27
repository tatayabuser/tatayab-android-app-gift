package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class AlsoProductModel(

    @SerializedName("id") val id: String? = null,
    @SerializedName("image_pair") val mImagePairModel: ImagePairModel? = null,
    @SerializedName("full_details") val mFullDetailsModel: FullDetailsModel? = null

    ) : Parcelable


/*{

                "shared_between_companies": [
                    "1"
                ],
                "ristrict_category_data": {
                    "2": {
                        "name": "Women",
                        "country_codes": []
                    },
                    "8": {
                        "name": "Fragrances",
                        "country_codes": []
                    },
                    "101": {
                        "name": "French Perfumes",
                        "country_codes": []
                    },
                    "214": {
                        "name": "International Perfumes",
                        "country_codes": []
                    },
                    "107": {
                        "name": "NBK - SHOP",
                        "country_codes": []
                    },
                    "52": {
                        "name": "Offers",
                        "country_codes": []
                    }
                },
                "sd_collection_products": [],
                "seo_snippet": {
                    "sku": "LAL-001-R370",
                    "name": "Lalique Le Parfum - 100 ML",
                    "description": "Lalique Le Parfum - 100 ML :Vanilla, Tonka Bean, Sandalwood, Pink Pepper, Almond, Patchouli, Jasmine, Bergamot",
                    "availability": "InStock",
                    "price_currency": "KWD",
                    "price": 14.5,
                    "show_price": true
                },
                "display_price": "14.500",
                "warehouse": {
                    "country_code": "KW",
                    "deli_from": "Thu. 01 Oct.",
                    "deli_to": "Tue. 29 Sep.",
                    "country": "Kuwait",
                    "amount": "19",
                    "warehouse_id": "1",
                    "image": "/flags/KW.png"
                },
                "have_required": "N",
                "selected_options": [],
                "has_options": false,
                "product_options": [],
                "list_discount": 35.25,
                "list_discount_prc": "71",
                "discounts": {
                    "A": 0,
                    "P": 0
                },
                "qty_content": [],
                "average_rating": "5.00",
                "supplier_name": "Lalique - French Perfumes",
                "category": "Women",
                "product_specs": [
                    {
                        "label": "Gender",
                        "value": "Female"
                    },
                    {
                        "label": "Product size",
                        "value": "100ml"
                    },
                    {
                        "label": "Product Type",
                        "value": "Perfume"
                    },
                    {
                        "label": "Brand",
                        "value": "Lalique"
                    }
                ],
                "product_link": "https://tatayab.com/en/perfumes/women/lalique-le-parfum-100-ml/"
            }
        },*/

