package com.example.mystore.model

import androidx.compose.runtime.Immutable

@Immutable
data class ProductCollection(
    val id: Long,
    val name: String,
    val snacks: List<Product>,
    val type: CollectionType = CollectionType.Normal
)
enum class CollectionType { Normal, Highlight }

object ProductRepo {
    fun getProduct(): List<ProductCollection> = productCollections
    fun getProduct(snackId: Long) = products.find { it.id == snackId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
    fun getInspiredByCart() = inspiredByCart
    fun getFilters() = filters
    fun getCart() = cart
}

/**
 * Static data
 */

private val tastyTreats = ProductCollection(
    id = 1L,
    name = "Android's picks",
    type = CollectionType.Highlight,
    snacks = products.subList(0, 13)
)

private val popular = ProductCollection(
    id = 2L,
    name = "Popular on Jetsnack",
    snacks = products.subList(14, 19)
)

private val wfhFavs = tastyTreats.copy(
    id = 3L,
    name = "WFH favourites"
)

private val newlyAdded = popular.copy(
    id = 4L,
    name = "Newly Added"
)

private val exclusive = tastyTreats.copy(
    id = 5L,
    name = "Only on Jetsnack"
)

private val also = tastyTreats.copy(
    id = 6L,
    name = "Customers also bought"
)

private val inspiredByCart = tastyTreats.copy(
    id = 7L,
    name = "Inspired by your cart"
)

private val productCollections = listOf(
    tastyTreats,
    popular,
    wfhFavs,
    newlyAdded,
    exclusive
)

private val related = listOf(
    also,
    popular
)

private val cart = listOf(
    OrderLine(products[4], 2),
    OrderLine(products[6], 3),
    OrderLine(products[8], 1)
)

@Immutable
data class OrderLine(
    val Product: Product,
    val count: Int
    )