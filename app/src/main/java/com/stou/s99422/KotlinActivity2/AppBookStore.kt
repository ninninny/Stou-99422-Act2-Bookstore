package com.stou.s99422.KotlinActivity2

import kotlin.system.exitProcess

fun login(){

}

fun loginCheck(){

}

fun quit(){
    println("======================================")
    println("Hope to see you again.")
    exitProcess(0)
}

private fun addData(b:BookService){
    b.submit("Introduction to Kotlin", "Pirom Konglerd", 650)
    b.submit("Mobile Application Programming", "Matha Roger", 990)
    b.submit("English is Fun!", "Steve", 100)
}

private  fun showMainMenu(){
    println("======================================")
    println("                    Welcome to the Kotlin Book Store                      ")
    println("======================================")
    println("ENTER 1 to List all books on shelf.")
    println("ENTER 2 to Login to shopping.")
    println("ENTER 9 to Quit program.")
}


fun main(){
    val bookShelf = hashMapOf<String, Book>()
    val bs = BookService(bookShelf)
    addData(bs)

    while (true){
        showMainMenu()
        print("Please enter command code: ")
        when(readLine().toString().trim()){
            "1" -> bs.list(bookShelf)
            "2" -> println("2")
            "9" -> quit()
            else  -> println("Invalid command, please try again.")
        }
    }

} // END main()