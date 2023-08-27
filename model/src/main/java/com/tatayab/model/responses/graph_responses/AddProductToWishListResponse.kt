package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class GraphAddProductToWishListResponse(@SerializedName("data") val data: AddDataFromWishlist) : BaseGrapgQlResponse()
data class AddDataFromWishlist(@SerializedName("addProductsToWishlist")val addProductsToWishlist : AddProductsToWishlist)
data class AddProductsToWishlist(@SerializedName("wishlist") val wishlist: AddWishListData)
data class AddWishListData(@SerializedName("id")val wishlistId: String, val items_count: Int,@SerializedName("items_v2") val items:wishListItemModel)
data class wishListItemModel(@SerializedName("items")val wishListItemsList: ArrayList<WishListItem>)


data class RemoveFromWishListResponse(val data : RemoveDataFromWishlist)
data class RemoveDataFromWishlist(val removeProductsFromWishlist : RemoveProductsFromWishlist)
data class RemoveProductsFromWishlist(val wishlist : RemoveWishListData, val user_errors : List<UserError>)
data class UserError (val code : String, val message:String)
data class RemoveWishListData (val id: String)
/*{
  "data": {
    "addProductsToWishlist": {
      "wishlist": {
        "id": "541",
        "items_count": 1,
        "items_v2": {
          "items": [
            {
              "id": "3258",
              "quantity": 1,
              "product": {
                "uid": "MjcxMw==",
                "name": "Gentlemen Only Eau De Toilette - 100ML - Men",
                "sku": "GVC-001-R364",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 434.35
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 434.35
                    }
                  }
                }
              }
            },
            {
              "id": "3260",
              "quantity": 1,
              "product": {
                "uid": "NTkxNA==",
                "name": "Baraonda Extrait De Parfum - 30ML - Unisex",
                "sku": "NAS-001-S303",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 719.78
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 719.78
                    }
                  }
                }
              }
            },
            {
              "id": "4468",
              "quantity": 1,
              "product": {
                "uid": "MjczMA==",
                "name": "Amouage Interlude - 100 ML",
                "sku": "AMG-001-R290",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 1427.15
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 1427.15
                    }
                  }
                }
              }
            },
            {
              "id": "4475",
              "quantity": 1,
              "product": {
                "uid": "MjgzMQ==",
                "name": "Chopard Oud Malaki - 80 ML",
                "sku": "CPD-001-R452",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 521.22
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 521.22
                    }
                  }
                }
              }
            },
            {
              "id": "4476",
              "quantity": 1,
              "product": {
                "uid": "MzcyMw==",
                "name": "Narciso Rodriguez Eau de Rouge - EDP -(women) 90ML",
                "sku": "NAR-001-R703",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 617.4
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 617.4
                    }
                  }
                }
              }
            },
            {
              "id": "4477",
              "quantity": 1,
              "product": {
                "uid": "Mzk4NA==",
                "name": "Memo Irish Leather (Unisex) - EDP -75 ML",
                "sku": "MEM-001-R810",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 967.98
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 967.98
                    }
                  }
                }
              }
            },
            {
              "id": "5144",
              "quantity": 1,
              "product": {
                "uid": "NDU5Ng==",
                "name": "Dior Homme Intense Eau De Parfum - 100ML - Male",
                "sku": "DIO-001-R975",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 694.96
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 694.96
                    }
                  }
                }
              }
            },
            {
              "id": "5145",
              "quantity": 1,
              "product": {
                "uid": "NDg2Mg==",
                "name": "Accento Eau De Parfum - 100ML - Unisex",
                "sku": "SPR-001-S045",
                "price_range": {
                  "minimum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 1216.18
                    }
                  },
                  "maximum_price": {
                    "regular_price": {
                      "currency": "SAR",
                      "value": 1216.18
                    }
                  }
                }
              }
            }
          ]
        }
      },
      "user_errors": []
    }
  }
}*/


