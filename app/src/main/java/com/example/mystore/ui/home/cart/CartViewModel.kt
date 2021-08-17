package com.example.mystore.ui.home.cart

import androidx.lifecycle.ViewModel
import com.example.mystore.model.OrderLine
import com.example.mystore.model.ProductRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel:ViewModel(){
    private val _orderLines:MutableStateFlow<List<OrderLine>> =MutableStateFlow(ProductRepo.getCart())
    val orderLines:StateFlow<List<OrderLine>> get() = _orderLines

    fun removeProduct(productId:Long){
        _orderLines.value=orderLines.value.filter { it.product.id !=productId }
    }
    fun increaseProductCount(productId:Long){
        val currentCount=_orderLines.value.first {it.product.id== productId}.count
        updateProductCount(productId,currentCount+1)
    }
    fun decreaseProductCount(productId: Long){
        val CurrentCount=_orderLines.value.first{it.product.id==productId}.count
        if(CurrentCount==1){
            removeProduct(productId = productId)
        }
    }
    private fun  updateProductCount(productId: Long,count:Int){
        _orderLines.value=_orderLines.value.map {
            if(it.product.id==productId){
                it.copy(count = count)
            }
            else{it}
        }
    }
}

