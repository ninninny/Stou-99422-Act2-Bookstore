package com.stou.s99422.KotlinActivity2

data class MemberService(
    var map: HashMap<String, Customer>
){
    fun register(username:String, name:String, pass:String, phone:String, addr:String){
        val c = Customer()
        c.cusID = username
        c.cusName = name
        c.cusPass = pass
        c.cusPhone = phone
        c.cusAddress = addr

        map.put(username,c)
    }// END register

    fun login(user:String, pass:String):Customer {
        var memLogin = Customer()
        for(i in map){
            if(user.equals(i.key) && pass.equals(i.value.cusPass)){
                memLogin = i.value
                break
            } else {

            }
        }
        return memLogin
    }// END login

    fun logout():Customer{
        return Customer("c0000")
    }
}
