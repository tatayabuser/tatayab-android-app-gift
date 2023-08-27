package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.*

data class CustomerFeaturedProductsResponse(
    @SerializedName("block_id")
    val blockId: String,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("content")
    val content: Content,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("products")
    val products: List<AlsoProductModel>,
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("type")
    val type: String
)

/*{
    "block_id": "77",
    "type": "products",
    "properties": {
        "template": "blocks/products/short_list.tpl",
        "hide_add_to_cart_button": "Y"
    },
    "company_id": "1",
    "lang_code": "en",
    "name": "CUSTOMER'S ALSO BOUGHT",
    "content": {
        "items": {
            "filling": "also_bought",
            "limit": "5",
            "cid": ""
        }
    },
    "products": [
        {
            "id": "2744",
            "image_pair": {
                "pair_id": "12214",
                "image_id": "0",
                "detailed_id": "13340",
                "position": "1",
                "detailed": {
                    "object_id": "2744",
                    "object_type": "product",
                    "type": "M",
                    "image_path": "https://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                    "alt": "",
                    "image_x": "450",
                    "image_y": "368",
                    "http_image_path": "http://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                    "https_image_path": "https://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                    "absolute_path": "/home/tatayab/public_html/images/detailed/13/LAL-001-R370.jpg",
                    "relative_path": "detailed/13/LAL-001-R370.jpg"
                }
            },
            "full_details": {
                "min_items_in_box": 0,
                "max_items_in_box": 0,
                "box_length": 0,
                "box_width": 0,
                "box_height": 0,
                "product_id": 2744,
                "product_code": "LAL-001-R370",
                "product_type": "P",
                "status": "A",
                "company_id": "1",
                "list_price": "49.750",
                "amount": "19",
                "weight": "0.400",
                "length": "0",
                "width": "0",
                "height": "0",
                "shipping_freight": "0.00",
                "low_avail_limit": "0",
                "timestamp": "1560779436",
                "updated_timestamp": "1600419316",
                "usergroup_ids": "0",
                "is_edp": "N",
                "edp_shipping": "N",
                "unlimited_download": "N",
                "tracking": "B",
                "free_shipping": "N",
                "zero_price_action": "R",
                "is_pbp": "N",
                "is_op": "N",
                "is_oper": "N",
                "is_returnable": "Y",
                "return_period": "10",
                "avail_since": "0",
                "out_of_stock_actions": "N",
                "localization": "",
                "min_qty": "0",
                "max_qty": "6",
                "qty_step": "0",
                "list_qty_count": "0",
                "tax_ids": [
                    "6",
                    "9"
                ],
                "age_verification": "N",
                "age_limit": "0",
                "options_type": "P",
                "exceptions_type": "F",
                "details_layout": "default",
                "shipping_params": "a:5:{s:16:\"min_items_in_box\";i:0;s:16:\"max_items_in_box\";i:0;s:10:\"box_length\";i:0;s:9:\"box_width\";i:0;s:10:\"box_height\";i:0;}",
                "facebook_obj_type": "",
                "parent_product_id": "0",
                "variation_code": null,
                "variation_options": null,
                "buy_now_url": "",
                "supplier_commission": "36.00",
                "is_featured": "Y",
                "show_featured_label": "N",
                "featured_position": "5",
                "available_countries": [],
                "location": "RM-AB-01-10",
                "collection_type": "S",
                "enable_one_click_buy": "Y",
                "is_default_variation": "N",
                "cost_price": "0.000",
                "is_free_delivery": "N",
                "free_available_countries": [],
                "lang_code": "en",
                "product": "Lalique Le Parfum - 100 ML",
                "shortname": "",
                "short_description": "",
                "full_description": "<strong>Lalique Le Parfum - 100 ML :</strong><br />Vanilla, Tonka Bean, Sandalwood, Pink Pepper, Almond, Patchouli, Jasmine, Bergamot",
                "meta_keywords": "Lalique Le Parfum - 100 ML     TATAYAB.COM",
                "meta_description": "Lalique Le Parfum - 100 ML | Lalique Le Parfum - 100 ML :Vanilla, Tonka Bean, Sandalwood, Pink Pepper, Almond, Patchouli, Jasmine, Bergamot",
                "search_words": "لاليك أحمر لو بارفوم -100 مل",
                "page_title": "Lalique Le Parfum - 100 ML | Tatayab",
                "age_warning_message": null,
                "promo_text": "",
                "amp_description": "",
                "price": "14.500",
                "category_ids": [
                    "2",
                    "8",
                    "101",
                    "214",
                    "107",
                    "52"
                ],
                "popularity": "46291",
                "supplier_id": "98",
                "sales_amount": "358",
                "seo_name": "lalique-le-parfum-100-ml",
                "seo_path": "8/2",
                "ab__pfe05_condition": "new",
                "ab__pfe04_condition": "new",
                "country_base_price": "49.75",
                "country_shipping_status": "0",
                "country_price": "14.5",
                "wpc_id": "27061",
                "wh_id": "1",
                "discussion_type": "B",
                "base_price": "14.500",
                "main_category": 2,
                "image_pairs": [],
                "main_pair": {
                    "pair_id": "12214",
                    "image_id": "0",
                    "detailed_id": "13340",
                    "position": "1",
                    "detailed": {
                        "object_id": "2744",
                        "object_type": "product",
                        "type": "M",
                        "image_path": "https://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                        "alt": "",
                        "image_x": "450",
                        "image_y": "368",
                        "http_image_path": "http://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                        "https_image_path": "https://tatayab.com/images/detailed/13/LAL-001-R370.jpg",
                        "absolute_path": "/home/tatayab/public_html/images/detailed/13/LAL-001-R370.jpg",
                        "relative_path": "detailed/13/LAL-001-R370.jpg"
                    }
                },
                "shared_product": "N",
                "product_features": {
                    "21": {
                        "feature_id": "21",
                        "value": "",
                        "value_int": null,
                        "variant_id": "5493",
                        "feature_type": "S",
                        "description": "Gender",
                        "prefix": "",
                        "suffix": "",
                        "variant": "Female",
                        "parent_id": "20",
                        "display_on_header": "N",
                        "display_on_catalog": "Y",
                        "display_on_product": "Y",
                        "features_hash": "10-5493",
                        "variants": {
                            "5493": {
                                "value": "",
                                "value_int": null,
                                "variant_id": "5493",
                                "variant": "Female",
                                "image_pairs": false
                            }
                        }
                    },
                    "25": {
                        "feature_id": "25",
                        "value": "",
                        "value_int": null,
                        "variant_id": "5598",
                        "feature_type": "S",
                        "description": "Product size",
                        "prefix": "",
                        "suffix": "",
                        "variant": "100ml",
                        "parent_id": "20",
                        "display_on_header": "N",
                        "display_on_catalog": "Y",
                        "display_on_product": "Y",
                        "features_hash": "8-5598",
                        "variants": {
                            "5598": {
                                "value": "",
                                "value_int": null,
                                "variant_id": "5598",
                                "variant": "100ml",
                                "image_pairs": false
                            }
                        }
                    },
                    "13": {
                        "feature_id": "13",
                        "value": "",
                        "value_int": null,
                        "variant_id": "5561",
                        "feature_type": "S",
                        "description": "Product Type",
                        "prefix": "",
                        "suffix": "",
                        "variant": "Perfume",
                        "parent_id": "12",
                        "display_on_header": "N",
                        "display_on_catalog": "Y",
                        "display_on_product": "Y",
                        "features_hash": "4-5561",
                        "variants": {
                            "5561": {
                                "value": "",
                                "value_int": null,
                                "variant_id": "5561",
                                "variant": "Perfume",
                                "image_pairs": false
                            }
                        }
                    },
                    "28": {
                        "feature_id": "28",
                        "value": "",
                        "value_int": null,
                        "variant_id": "6697",
                        "feature_type": "E",
                        "description": "Brand",
                        "prefix": "",
                        "suffix": "",
                        "variant": "Lalique",
                        "parent_id": "26",
                        "display_on_header": "N",
                        "display_on_catalog": "Y",
                        "display_on_product": "Y",
                        "features_hash": "9-6697",
                        "variants": {
                            "6697": {
                                "value": "",
                                "value_int": null,
                                "variant_id": "6697",
                                "variant": "Lalique",
                                "image_pairs": false
                            }
                        }
                    }
                },
                "detailed_params": {
                    "info_type": "D",
                    "get_options": true,
                    "get_icon": true,
                    "get_detailed": true,
                    "get_additional": true,
                    "get_discounts": true,
                    "get_features": true,
                    "get_extra": false,
                    "get_taxed_prices": true,
                    "get_for_one_product": true,
                    "detailed_params": true,
                    "features_display_on": "A"
                },
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