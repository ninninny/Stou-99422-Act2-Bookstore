package com.stou.s99422.KotlinActivity2

fun main(){

    val booksMap = hashMapOf<String, Book>()
    val bs = BookService(booksMap)

    while (true){
        println("================================")

        print("Please enter book's name: ")
        val bName = readLine().toString().trim()
        if(bName.equals("quit", true)){break}

        print("Please enter book's author: ")
        val bAuthor = readLine().toString().trim()

        print("Please enter book's price: ")
        val bPrice = readLine().toString().trim().toInt()

        bs.submit(bName, bAuthor, bPrice)

    }
    println("================================")
    println("List of all books: ")
    bs.list()
    println("")
    bs.bookCount()
    println("================================")
    println("List of books under 250 Baht: ")
    bs.list(booksMap.filterValues {it.bookPrice<250} as HashMap<String, Book>)
    println("================================")
    println("The details for 'Introduction to Kotlin' : ")
    bs.list(booksMap.filterValues{it.bookName.equals("Introduction to Kotlin", true)} as HashMap<String, Book>)
    println("================================")
    println("The books about 'Mobile' : ")
    bs.list(booksMap.filterValues{it.bookName.contains("Mobile", true)} as HashMap<String, Book>)
    println("================================")

}