package com.stou.s99422.KotlinActivity2

import java.time.LocalDate

data class Order(
    var orderID:String = "S0000",
    var orderCus:Customer? = null,
    var orderBook:Book? = null,
    var orderDate:LocalDate = LocalDate.now()
)
