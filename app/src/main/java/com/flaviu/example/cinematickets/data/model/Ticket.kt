package com.flaviu.example.cinematickets.data.model

abstract class Ticket {
    // TODO: this should be handled by server side on a production environment
    val id = (0..100).random()

    // TODO: values should come from backend on a production environment
    abstract val price: Double
    val real3DPrice = 0.90
    val imaxPrice = 1.50

    var hasReal3D = false
    var hasImax = false

    // TODO: this should be determined at the time of buying on a production environment (e.g check the current date to see if it's a Thursday)
    var is3For1 = false
}