package com.example.restaurant.model

data class Cart(var id: Int?,var photo: Int, var name: String, var GHS: String, var count: Int) {

    override fun toString(): String {
        return "Cart { id: $id, photo: $photo, name: $name, GHS: $GHS, count: $count}"
    }
}