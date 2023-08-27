package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class GraphMainCategoriesResponse(@SerializedName("data") val data: CategoryData) :
    Parcelable,BaseGrapgQlResponse() {

    @Parcelize
    class CategoryData(@SerializedName("categoryList") val categoryListItem: List<GraphCategoryItemResponse>? = null) :
        Parcelable

    @Parcelize
    open class CategoryListItem(@SerializedName("children") val children: List<GraphCategoryItemResponse>? = null) :
        Parcelable

    @Parcelize
    open class GraphCategoryItemResponse(
        @SerializedName("children_count") val children_count: String?="",
        @SerializedName("id") val id: Int?=0,
        @SerializedName("level") val level: Int?=0,
        @SerializedName("uid") val uid: String?="",
        @SerializedName("name") val name: String?="",
        @SerializedName("image") val image: String
    ) : Parcelable

}
/*{"data":{"categoryList":[{"children_count":"11","id":5,"uid":"NQ==","cscart_id":9,"level":2,"name":"Offers","image":"https:\/\/tatayab.com\/media\/catalog\/category\/unnamed.png","path":"1\/2\/5"},{"children_count":"22","id":4,"uid":"NA==","cscart_id":8,"level":2,"name":"Fragrances","image":"https:\/\/tatayab.com\/media\/catalog\/category\/perfumes.png","path":"1\/2\/4"},{"children_count":"35","id":40,"uid":"NDA=","cscart_id":425,"level":2,"name":"Makeup","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Make_up-03.png","path":"1\/2\/40"},{"children_count":"8","id":38,"uid":"Mzg=","cscart_id":246,"level":2,"name":"Bukhour ","image":"https:\/\/tatayab.com\/media\/catalog\/category\/bukhour_icona.png","path":"1\/2\/38"},{"children_count":"3","id":37,"uid":"Mzc=","cscart_id":240,"level":2,"name":"Dihn oud & Musk","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Arabic_musk_perfume.png","path":"1\/2\/37"},{"children_count":"10","id":3,"uid":"Mw==","cscart_id":7,"level":2,"name":"Home Scents","image":"https:\/\/tatayab.com\/media\/catalog\/category\/home_fragrances_icona.png","path":"1\/2\/3"},{"children_count":"53","id":34,"uid":"MzQ=","cscart_id":168,"level":2,"name":"Body care","image":"https:\/\/tatayab.com\/media\/catalog\/category\/body_care_icona.png","path":"1\/2\/34"},{"children_count":"58","id":33,"uid":"MzM=","cscart_id":131,"level":2,"name":"Skin care","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Skin-Care.png","path":"1\/2\/33"},{"children_count":"7","id":8,"uid":"OA==","cscart_id":50,"level":2,"name":"Mubkhars & Accessories","image":"https:\/\/tatayab.com\/media\/catalog\/category\/mubkhar_icona.png","path":"1\/2\/8"},{"children_count":"20","id":6,"uid":"Ng==","cscart_id":15,"level":2,"name":"Hair care","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Hair-Care.png","path":"1\/2\/6"},{"children_count":"13","id":52,"uid":"NTI=","cscart_id":1065,"level":2,"name":"Mum & Baby Care","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Mum-_-Baby.png","path":"1\/2\/52"},{"children_count":"0","id":485,"uid":"NDg1","cscart_id":0,"level":2,"name":"Gifts","image":"https:\/\/tatayab.com\/media\/catalog\/category\/Gift-Icon.png","path":"1\/2\/485"}]}}
*/


@Parcelize
open class GraphSubCategoriesResponse(@SerializedName("data") val data: CategoryData) :
    Parcelable {

    @Parcelize
    class CategoryData(@SerializedName("categories") val categories: SubCategoryListItem) :
        Parcelable

    @Parcelize
    open class SubCategoryListItem(@SerializedName("items") val items: List<GraphSubCategoryItem>? = null) :
        Parcelable
    @Parcelize
    data class GraphSubCategoryItem(
        @SerializedName("mp_promo_banners") val mp_promo_banners: MPromoBanner,
        @SerializedName("id") val id: String,
        @SerializedName("uid") val uid: String,
        @SerializedName("name") val name: String,
        @SerializedName("image") val image: String,
        @SerializedName("children_count") val children_count: Int,
        @SerializedName("children") val childrenList: List<GraphSubCategoryItemResponse>
    ):   Parcelable

    @Parcelize
    open class GraphSubCategoryItemResponse(
        @SerializedName("id") val id: String,
        @SerializedName("uid") val uid: String,
        @SerializedName("name") val name: String,
        @SerializedName("image") val image: String,
        @SerializedName("children_count") val children_count: Int
    ) : Parcelable

    @Parcelize data class MPromoBanner(val items: List<GraphBannerItem>) :  Parcelable


    /*
    * {
	"data": {
		"categories": {
			"total_count": 7,
			"items": [
				{
					"children_count": "0",
					"id": 116,
					"uid": "MTE2",
					"level": 3,
					"name": "Skin Care Value Sets",
					"path": "1\/2\/33\/116",
					"image": "https:\/\/tatayab.com\/media\/catalog\/category\/Blemish-_-Acne-Treatments.jpg",
					"children": []
				},
				{
					"children_count": "32",
					"id": 110,
					"uid": "MTEw",
					"level": 3,
					"name": "Face Care",
					"path": "1\/2\/33\/110",
					"image": "https:\/\/tatayab.com\/media\/catalog\/category\/Skin_Care_Value_Sets_2.jpeg",
					"children": [
						{
							"id": 176,
							"uid": "MTc2",
							"level": 4,
							"name": "Anti Aging",
							"path": "1\/2\/33\/110\/176",
							"image": "https:\/\/tatayab.com\/media\/catalog\/category\/Anti-Aging.jpg",
							"children_count": "0"
						},*/
}


