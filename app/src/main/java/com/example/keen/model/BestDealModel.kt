package com.example.keen.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class BestDealModel(var item_id : String? = null,
                    var name : String? = null,
                    var image:String? = null)