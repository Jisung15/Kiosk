package com.example.kotlinproject

open class MainMenu (Name:String, Comment:String, Count: Int) {    // 메인 메뉴판에 대한 매개 변수(메뉴 이름, 번호, 설명)을 받아서 메인 메뉴판을 출력해주는 클래스
    var name = Name
    var count = Count
    var comment = Comment
    open fun menu () {
        println("${count}. ${name}   |   ${comment}")
    }
}