package com.example.kotlinproject

// 자식 클래스
class SubMenu (Name: String, Price: Double, Comment: String, Count: Int) : MainMenu(Name, Comment, Count) {      // 서브 메뉴판에 대한 매개 변수(메뉴 이름, 가격, 번호, 설명)을 받아서 서브 메뉴판을 출력해주는 클래스
    var price = Price
    override fun menu () {
        println("${count}. ${name}   |   ${comment}   |   W${price}")
    }
}