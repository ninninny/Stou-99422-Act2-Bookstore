package com.stou.s99422.KotlinActivity2

import kotlin.system.exitProcess

fun login(){

}

fun loginCheck(){

}

fun shopping(){

}

fun quit(){
    println("======================================")
    println("Hope to see you again.")
    exitProcess(0)
}

private fun addData(b:BookService, m:MemberService){
    b.submit("Introduction to Kotlin", "Pirom Konglerd", 650)
    b.submit("Mobile Application Programming", "Matha Roger", 990)
    b.submit("English is Fun!", "Steve", 100)
    m.register("Sanook","Jingdi","000-000-0000","Thailand, Bangkok")
}

private  fun showMainMenu(){
    println("======================================")
    println("                    Welcome to the Kotlin Book Store                      ")
    println("======================================")
    println("ENTER 1 to Rgister")
    println("ENTER 2 to List all books on shelf.")
    println("ENTER 3 to Login to shopping.")
    println("ENTER 9 to Quit program.")
}

private  fun showMemberMenu(){
    println("======================================")
    println("                      Kotlin Book Store Shopping Cart                        ")
    println("======================================")
    print("Please enter book's name: ")
    val bName = readLine().toString()
    // Check if the book on shelf
}


fun main(){
    val bookShelf = hashMapOf<String, Book>()
    val memData = hashMapOf<String, Customer>()
    val bs = BookService(bookShelf)
    val ms = MemberService(memData)
    addData(bs,ms)

    while (true){
        showMainMenu()
        print("Please enter command code: ")
        when(readLine().toString().trim()){
            "1" -> println("Member Register")
            "2" -> bs.list(bookShelf)
            "3" -> println("Login")
            "9" -> quit()
            else  -> println("Invalid command, please try again.")
        }
    }

} // END main()