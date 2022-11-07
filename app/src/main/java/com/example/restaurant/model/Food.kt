package com.example.restaurant.model

import java.io.Serializable

data class Food(var id: Int?,var image: Int, var name: String, var price: String): Serializable {

    override fun toString(): String {
        return "Food { id: $id, image: $image, name: $name, price: $price }"
    }
}