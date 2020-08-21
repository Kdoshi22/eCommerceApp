package com.example.keen.model

class BestDealModel {
    var item_id : String? = null
    var name : String? = null
    var image:String? = null

    constructor(image : String? , item_id : String? , name : String?){
        this.image = image
        this.item_id = item_id
        this.name = name
    }
}