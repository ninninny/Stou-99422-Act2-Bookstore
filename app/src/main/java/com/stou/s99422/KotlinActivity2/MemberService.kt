package com.stou.s99422.KotlinActivity2

data class MemberService(
    var map: HashMap<String, Customer>
){
    fun register(name:String, pass:String, phone:String, addr:String){
        val c = Customer()
        c.cusID = "c"+(map.size+1).toString().padStart(4, '0')
        c.cusName = name
        c.cusPass = pass
        c.cusPhone = phone
        c.cusAddress = addr

        map.put(c.cusID,c)
    }
}
