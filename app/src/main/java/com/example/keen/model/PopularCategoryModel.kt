package com.example.keen.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PopularCategoryModel(
    var image:String? = null,
    var item_id : String? = null,
    var name : String? = null)

    /*constructor(image : String? , item_id : String? , name : String?){
        this.item_id = item_id
        this.name = name
        this.image = image
    }*/
