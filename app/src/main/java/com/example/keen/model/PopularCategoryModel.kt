package com.example.keen.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PopularCategoryModel(var image:String? = null,
                                var item_id : String? = null,
                                var name : String? = null)