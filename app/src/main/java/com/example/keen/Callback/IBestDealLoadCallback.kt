package com.example.keen.Callback

import com.example.keen.model.BestDealModel

interface IBestDealLoadCallback {
    fun onBestDealLoadSuccess(bestDealList: List<BestDealModel>)
    fun onBestDealLoadFailed(message:String)
}