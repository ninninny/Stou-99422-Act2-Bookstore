package com.stou.s99422.KotlinActivity2

import kotlin.system.exitProcess

fun memRegister(m:MemberService){
    println("=================================================================")
    println("                      Member Registration")
    println("=================================================================")
    print("Username: ")
    val username = readLine().toString().trim()
    print("Password: ")
    val pass = readLine().toString().trim()
    print("Name: ")
    val name = readLine().toString().trim()
    print("Phone Number: ")
    val phone = readLine().toString().trim()
    print("Address: ")
    val addr = readLine().toString().trim()

    while(true){ println("=================================================================")
    println("Please check your information")
    println("Userame: ${username}")
    println("Password: ${pass}")
        println("Name: ${name}")
    println("Phone Number: ${phone}")
    println("Address: ${addr}")
    print("Enter 1 to confirm / 0 to cancel :")
    when(readLine().toString()){
        "1" -> {
            m.register(username,name,pass,phone,addr)
            println("Registration succeed.")
            break
        }
        "0" -> {
            println("Registration canceled.")
            break
        }
        else -> println("Invalid command, please check again.")
    }
    }
}

fun memLogin(bs:BookService, ms:MemberService, books:HashMap<String, Book>){
    val orders = hashMapOf<String, Order>()
    val os = OrderService(orders)
    println("=================================================================")
    println("                      Member Login")
    println("=================================================================")
    print("Username: ")
    val username = readLine().toString().trim()
    print("Password: ")
    val pass = readLine().toString().trim()
    val customer = ms.login(username,pass)
    if(customer.cusID.equals("c0000")){
        println("__________________________________________________________________")
        println("The login session unsuccessful.")
    } else{
        while(true){
        showMemberMenu(customer)
        print("Please enter command code: ")
        when(readLine().toString().trim()){
            "1" -> bs.list()
            "2" -> shopping(orders, os, books, customer)
            "3" -> billing(os, customer)
            "9" -> {
                ms.logout()
                println("__________________________________________________________________")
                println("Logout.")
                break
            }
            else  -> println("Invalid command, please try again.")
        }
        }
    }

}

fun shopping(o:HashMap<String, Order>, os:OrderService, books:HashMap<String, Book>, c:Customer){

    var bookCount:Int = 0
    while(true){
    println("__________________________________________________________________")
    println("Select book(s) to add to cart or enter 'quit' to end shopping.")
    print("Book's name: ")
    val bName = readLine().toString().trim()

    if(bName.equals("quit",true)){

            println("__________________________________________________________________")
            println("There is ${bookCount} books of ${o.size} titles on your shopping cart")
            os.list()
            println("__________________________________________________________________")
            println("Total :${os.priceTotal()} THB")

            print("Enter 1 to buy more or 0 to end shopping.")
            when(readLine().toString().trim()){
                "1" -> print("")
                "0" -> break
                else -> {
                    println("Invalid command, please try again.")
                    break
                }
            }

    } else if(books.any { it.value.bookName.equals(bName, true)}){
        var theBook:Book? = null
        books.forEach{
            if(it.value.bookName.equals(bName, true)){
                theBook = it.value
            }
        }

        print("Quantity: ")
        val bQty = readLine().toString().toInt()
        bookCount += bQty
        os.placeOrder(c,theBook,bQty)
    } else {
        println("__________________________________________________________________")
        println("Sorry, the book has not found on shelf.")
    }
    }

} // END Shopping

fun billing(os: OrderService, c: Customer){
    println("__________________________________________________________________")
    //os.list()
    os.createBill(c)
}

fun quit(){
    println("__________________________________________________________________")
    println("Hope to see you again.")
    exitProcess(0)
}

private fun addData(b:BookService, m:MemberService){
    b.submit("Introduction to Kotlin", "Pirom Konglerd", 650)
    b.submit("Mobile Application Programming", "Matha Roger", 990)
    b.submit("English is Fun", "Steve Something", 100)
    b.submit("Easy Read", " Nice Teacher", 50)
    m.register("Sanook","Sanook","Jingdi","000-000-0000","Thailand, Bangkok")
}

private  fun showMainMenu(){
    println("=================================================================")
    println("              Welcome to the Kotlin Book Store")
    println("=================================================================")
    println("ENTER 1 :: Register")
    println("ENTER 2 :: Login to shopping.")
    println("ENTER 9 :: Quit program.")
}

private  fun showMemberMenu(cus:Customer){
    println("=================================================================")
    println("             Welcome ${cus.cusName} to the store")
    println("=================================================================")
    println("ENTER 1 :: List all books on shelf.")
    println("ENTER 2 :: Shopping.")
    println("ENTER 3 :: View Order(s).")
    println("ENTER 9 :: Logout.")
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
            "1" -> memRegister(ms)
            "2" -> memLogin(bs,ms, bookShelf)
            "9" -> quit()
            else  -> println("Invalid command, please try again.")
        }
    }

} // END main()