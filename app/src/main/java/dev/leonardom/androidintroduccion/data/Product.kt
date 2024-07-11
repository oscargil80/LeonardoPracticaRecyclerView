package dev.leonardom.androidintroduccion.data

data class Product(
    val id: Long,
    val name: String,
    val imageURL: String,
    val price: Float,
    val description: String
)
