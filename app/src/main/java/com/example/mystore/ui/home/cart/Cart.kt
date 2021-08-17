package com.example.mystore.ui.home.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mystore.model.ProductRepo
import com.example.mystore.model.ProductCollection
import kotlinx.coroutines.flow.collect


@Composable
fun Cart(
    onSnackClick:(Long) -> Unit,
    modifier: Modifier =Modifier,
){
    val viewModel:CartViewModel= viewModel()
    val orderLines by viewModel.orderLines.collectAsState()
    val inspiredByCart = remember{ProductRepo.getInspiredByCart()}

}