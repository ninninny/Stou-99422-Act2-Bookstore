package com.stou.s99422.KotlinActivity2

data class BookService(
    var map: HashMap<String, Book>
){
    fun submit(name:String, author:String, price:Int){
        val b = Book()
        b.bookID = "b"+(map.size+1).toString().padStart(4, '0')
        b.bookName = name
        b.bookAuthor = author
        b.bookPrice = price

        map.put(b.bookID,b)
    }

    fun list(map: HashMap<String, Book>){
        println("----------------------------------------------------------------------------")
        map.forEach { println("${it.value.bookID} : ${it.value.bookName} by ${it.value.bookAuthor} - ${it.value.bookPrice} THB")}
    }

    fun bookCount(){
        when(map.size){
            0 -> println("Nothing been recorded.")
            1 -> println("There is 1 book been recorded.")
            else -> println("There are ${map.size} books been recorded.")
        }
    }

}
