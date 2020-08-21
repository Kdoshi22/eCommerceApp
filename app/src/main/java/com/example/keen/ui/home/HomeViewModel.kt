package com.example.keen.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.keen.Callback.IPopularLoadCallback
import com.example.keen.Common
import com.example.keen.model.PopularCategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class HomeViewModel : ViewModel() , IPopularLoadCallback {

    private var popularListMutableLiveData: MutableLiveData<List<PopularCategoryModel>>? = null
    private lateinit var messageError: MutableLiveData<String>
    private lateinit var popularLoadCallbackListener: IPopularLoadCallback

    override fun onPopularLoadSuccess(popularModelList: List<PopularCategoryModel>) {
        popularListMutableLiveData!!.value = popularModelList
    }

    override fun onPopularLoadFailed(message: String) {
        messageError.value = message
    }

    val popularList : LiveData<List<PopularCategoryModel>>
        get() {
            if(popularListMutableLiveData == null){
                popularListMutableLiveData = MutableLiveData()
                messageError = MutableLiveData()
                loadPopularList()
            }
            return popularListMutableLiveData!!
        }

    private fun loadPopularList() {
        val tempList = ArrayList<PopularCategoryModel>()
        val popularRef = FirebaseDatabase.getInstance().getReference(Common.POPULAR_REF)
        popularRef.addListenerForSingleValueEvent(object:ValueEventListener{

            override fun onCancelled(error: DatabaseError) {
                popularLoadCallbackListener.onPopularLoadFailed(error.message!!)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for(itemSnapShot in snapshot!!.children)
                {
                    val model = itemSnapShot.getValue<PopularCategoryModel>(PopularCategoryModel::class.java)
                    tempList.add(model!!)
                }
                popularLoadCallbackListener.onPopularLoadSuccess(tempList)
            }
        })
    }

    init {
        popularLoadCallbackListener = this
    }

}