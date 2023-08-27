package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductOptionsDetailed(
    @SerializedName("allowed_extensions")
    val allowedExtensions: String?=null,
    @SerializedName("comment")
    val comment: String?=null,
    @SerializedName("company_id")
    val companyId: String?=null,
    @SerializedName("description")
    val description: String?=null,
    @SerializedName("google_export_name_option")
    val googleExportNameOption: String?=null,
    @SerializedName("incorrect_message")
    val incorrectMessage: String?=null,
    @SerializedName("inner_hint")
    val innerHint: String?=null,
    @SerializedName("inventory")
    val inventory: String?=null,
    @SerializedName("max_file_size")
    val maxFileSize: String?=null,
    @SerializedName("missing_variants_handling")
    val missingVariantsHandling: String?=null,
    @SerializedName("multiupload")
    val multiupload: String?=null,
    @SerializedName("option_id")
    val optionId: String?=null,
    @SerializedName("option_name")
    val optionName: String?=null,
    @SerializedName("option_text")
    val optionText: String?=null,
    @SerializedName("option_type")
    val optionType: String?=null,
    @SerializedName("position")
    val position: String?=null,
    @SerializedName("product_id")
    val productId: String?=null,
    @SerializedName("regexp")
    val regexp: String?=null,
    @SerializedName("required")
    val required: String?=null,
    @SerializedName("status")
    val status: String?=null,
    @SerializedName("value")
    val value: Int?=null,
    @SerializedName("variants")
    val variants: Map<Int, Variant>?=null
):Parcelable