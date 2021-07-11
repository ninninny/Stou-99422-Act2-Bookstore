package com.stou.s99422.KotlinActivity2

import java.time.LocalDate

data class OrderService(
    var map: HashMap<String, Order>
){
    fun placeOrder(c:Customer, b:Book?,q:Int){
        var order = Order()
        order.orderID = "S"+(map.size+1).toString().padStart(4, '0')
        order.orderCus = c
        order.orderBook = b
        order.orderQty = q
        order.orderDate = LocalDate.now()
        map.put(order.orderID, order)
    }

    fun list(){
        println("__________________________________________________________________")
        map.forEach {
            println("${it.value.orderBook?.bookName} - ${it.value.orderBook?.bookPrice} THB x ${it.value.orderQty} qty")}
    }

    fun priceTotal():Int{
        var total:Int = 0
        map.forEach{
            total += it.value.orderBook?.bookPrice?.times(it.value.orderQty)!!
        }
        return total
    }

    fun createBill(c:Customer){
        println("Customer: ${c.cusName} [${c.cusAddress}, ${c.cusPhone}]")
        println("__________________________________________________________________")
        map.forEach{
            println("Date: ${it.value.orderDate}")
            println("Order ID: ${it.value.orderID}")
            println("${it.value.orderBook?.bookName} : by ${it.value.orderBook?.bookAuthor}")
            println("Price: ${it.value.orderBook?.bookPrice} x ${it.value.orderQty} qty")
            println("__________________________________________________________________")
        }
        println("Total: "+priceTotal()+" THB")

    }
}
