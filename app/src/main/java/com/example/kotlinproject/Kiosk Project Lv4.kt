package com.example.kotlinproject

fun main () {
    init()
}

fun init () {

    first@ while (true) {
        try {
            println("")
            println("[ SHAKE MENU ]")
            var count = 1
            for (i in menuList) {
                val mainMenu = MainMenu(i.name, i.description, count)
                mainMenu.menu()
                count++
            }
            println("0. 종료    |    프로그램 종료")
            println("")
            println("메인 메뉴 번호를 입력하세요.")
            val menuNumber = readLine()!!.toInt()

            when (menuNumber) {
                in 1..menuList.size -> {
                    second@ while (true) {
                        var subIndex = menuList[menuNumber - 1]
                        println("")
                        println("[ ${subIndex.name} MENU ]")
                        var count = 1
                        for (subMenu in subIndex.subMenus) {
                            val sub = SubMenu(subMenu.name, subMenu.price, subMenu.comment, count)
                            sub.menu()
                            count++
                        }
                        println("0. 뒤로 가기   |   뒤로 가기")

                        try {
                            println("")
                            println("서브 메뉴 번호를 입력하세요. 메인 메뉴로 돌아가려면 0을 입력하세요.")
                            val subMenuNumber = readLine()!!.toInt()
                            if (subMenuNumber == 0) continue@first else if (subMenuNumber in 1..4) {
                                println("${subMenuNumber}번 메뉴를 선택하셨습니다. 이 상태로 바로 주문할까요?   [1] 주문 후 종료   [2] 메인 메뉴에서 계속 주문하기   [3] 서브 메뉴 한 번 더 선택하기")
                                val number = readLine()!!.toInt()
                                if (number == 1) break@first else if (number == 2) continue@first else if (number ==3) continue@second else {
                                    println("입력한 숫자가 선택지 범위를 벗어납니다. 서브 메뉴판으로 돌아갑니다. 서브 메뉴 번호를 다시 입력하세요.")
                                    continue@second
                                }
                            } else {
                                println("입력한 숫자가 서브 메뉴 번호 범위를 벗어납니다. 서브 메뉴 번호를 다시 입력하세요.")
                                continue
                            }
                        } catch (e: NumberFormatException) {
                            println("숫자가 아닌 것은 서브 메뉴 번호로 입력할 수 없습니다. 서브 메뉴 번호를 다시 입력하세요.")
                            continue
                        }
                    }
                }

                0 -> {
                    println("0을 입력하였으므로 키오스크 프로그램을 종료합니다.")
                    break
                }

                else -> {
                    println("입력한 숫자가 메인 메뉴 번호 범위를 벗어납니다. 메인 메뉴 번호를 다시 입력하세요.")
                    continue
                }
            }
        } catch (e: NumberFormatException) {
            println("숫자가 아닌 것은 메인 메뉴 번호로 입력할 수 없습니다. 메인 메뉴 번호를 다시 입력하세요.")
            continue
        }
    }
}

val menuList = listOf(
    MainValue("Burgers", "앵거스 비프 통살을 다져만든 버거", listOf(
        SubValue("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
        SubValue("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
        SubValue("Cheeseburger", 6.3, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
        SubValue("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    )),
    MainValue("Custard", "매장에서 신선하게 만드는 아이스크림", listOf(
        SubValue("frozen1", 3.2, "frozen custard num1"),
        SubValue("frozen2", 2.5, "frozen custard num2"),
        SubValue("frozen3", 4.3, "frozen custard num3"),
        SubValue("frozen4", 1.6, "frozen custard num4")
    )),
    MainValue("Drinks", "매장에서 직접 만드는 음료", listOf(
        SubValue("Orange Juice", 2.3, "오렌지를 갈아 만든 상큼한 오렌지 주스"),
        SubValue("Apple Juice", 1.2, "사과의 맛이 살아 있는 사과 주스"),
        SubValue("Pineapple Juice", 2.9, "파인 애플을 갈아서 만든 달콤한 파인애플 주스"),
        SubValue("Banana Juice", 2.5, "바나나의 부드러운 맛을 살린 바나나 주스")
    )),
    MainValue("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주", listOf(
        SubValue("beer1", 2.1, "시원하고 깔끔한 맛의 고급 맥주"),
        SubValue("beer2", 4.3, "맥주 첫 도전자를 위한 순한 맛의 맥주"),
        SubValue("beer3", 3.2, "맥주이지만 맥주같지 않은 맥주"),
        SubValue("beer4", 5.1, "신상품 맥주! 놓치지 말고 꼭 즐겨보세요")
    ))
)