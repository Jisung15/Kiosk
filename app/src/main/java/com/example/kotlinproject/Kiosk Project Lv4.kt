package com.example.kotlinproject

fun main () {
    init()
}
fun init () {
    val mainMenuName = listOf<String>("Burgers", "Custard", "Drinks", "Beer")   // 메인 메뉴판 메뉴 이름 리스트

    // 서브 메뉴판 메뉴 이름 리스트
    val menuName = listOf(
        listOf("ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"),
        listOf("frozen1", "frozen2", "frozen3", "frozen4"),
        listOf("Orange Juice", "Apple Juice", "Pineapple Juice", "Banana Juice"),
        listOf("beer1", "beer2", "beer3", "beer4")
    )
    // 서브 메뉴판 메뉴 가격 리스트
    val menuPrice = listOf(
        listOf(6.9, 8.9, 6.3, 5.4),
        listOf(3.2, 2.5, 4.3, 1.6),
        listOf(2.3, 1.2, 2.9, 2.5),
        listOf(2.1, 4.3, 3.2, 5.1)
    )
    // 메인, 서브 메뉴판 메뉴 설명 리스트
    val menuComment = listOf(
        listOf("앵거스 비프 통살을 다져만든 버거", "매장에서 신선하게 만드는 아이스크림", "매장에서 직접 만드는 음료", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
        listOf("토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", "비프패티를 기반으로 야채가 들어간 기본버거"),
        listOf("frozen custard num1", "frozen custard num2", "frozen custard num2", "frozen custard num3", "frozen custard num4"),
        listOf("오렌지를 갈아 만든 상큼한 오렌지 주스", "사과의 맛이 살아 있는 사과 주스", "파인 애플을 갈아서 만든 달콤한 파인애플 주스", "바나나의 부드러운 맛을 살린 바나나 주스"),
        listOf("시원하고 깔끔한 맛의 고급 맥주", "맥주 첫 도전자를 위한 순한 맛의 맥주", "맥주이지만 맥주같지 않은 맥주", "신상품 맥주! 놓치지 말고 꼭 즐겨보세요")
    )

    while (true) {
        // 메인 메뉴판에서 메뉴 번호로 숫자를 입력했을 때의 경우를 처리. 메인 메뉴판을 반복문을 이용해서 화면에 출력
        try {
            println("[ SHAKE MENU ]")
            var count = 1
            for (i in mainMenuName.indices) {
                val mainMenu = MainMenu(mainMenuName[i], menuComment[0][i], count)        // 메인 메뉴판 메뉴 이름, 설명, 번호를 각각 부모 클래스인 메인 메뉴판 출력하는 클래스에 넣음
                mainMenu.menu()
                count++
            }
            println("0. 종료    |    프로그램 종료")
            print("메인 메뉴 번호를 입력하세요. : ")    // 메인 메뉴 번호를 입력받음
            val menuNumber = readLine()!!.toInt()

            // 메인 메뉴 번호를 입력받은 결과에 따라 when문으로 조건을 설정함
            when (menuNumber) {
                1 -> {
                    println("[ Burger MENU ]")
                    var count = 1
                    for (i in menuName.indices) {
                        val burgers = SubMenu(menuName[0][i], menuPrice[0][i], menuComment[1][i], count)      // 서브 메뉴판 메뉴 이름, 가격, 설명, 번호를 각각 자식 클래스인 서브 메뉴판 출력하는 클래스에 넣음, 반복문으로 서브 메뉴판 출력
                        burgers.menu()
                        count++
                    }
                    println("0. 뒤로 가기   |   뒤로 가기")

                    // 여기서부터 서브 메뉴판에서 메뉴 번호를 입력했을 때 입력하는 숫자에 따라 경우를 찾아서 예외 처리
                    try {
                        print("서브 메뉴 번호를 입력하세요. 메인 메뉴로 돌아가려면 0을 입력하세요. : ")
                        val subMenuNumber = readLine()!!.toInt()
                        if (subMenuNumber == 0) continue else if (subMenuNumber in 1..4) {
                            println("잘못된 서브 메뉴 번호입니다. 처음으로 돌아갑니다.")             // 메뉴 번호 1~4 중 입력 했을 때 경우 실행
                            continue
                        } else {
                            println("입력한 숫자가 서브 메뉴 번호 범위를 벗어납니다. 처음으로 돌아갑니다.")           // 메뉴 번호 0~4 범위 밖 숫자를 입력 했을 때 실행
                            continue
                        }
                    } catch (e: NumberFormatException) {      // NumberFormatException을 이용해서 서브 메뉴 번호로 숫자가 아닌 문자를 입력했을 때의 경우를 예외 처리
                        println("숫자가 아닌 것은 서브 메뉴 번호로 입력할 수 없습니다. 처음으로 돌아갑니다.")
                        continue
                    }
                } 2 -> {
                    println("[ Frozen Custard MENU ]")
                    var count = 1
                    for (i in menuName.indices) {
                        val frozen = SubMenu(menuName[1][i], menuPrice[1][i], menuComment[2][i], count)
                        frozen.menu()
                        count++
                    }
                    println("0. 뒤로 가기   |   뒤로 가기")
                    try {
                        print("서브 메뉴 번호를 입력하세요. 메인 메뉴로 돌아가려면 0을 입력하세요. : ")
                        val subMenuNumber = readLine()!!.toInt()
                        if (subMenuNumber == 0) continue else if (subMenuNumber in 1..4) {
                            println("잘못된 서브 메뉴 번호입니다. 처음으로 돌아갑니다.")
                            continue
                        } else {
                            println("입력한 숫자가 서브 메뉴 번호 범위를 벗어납니다. 처음으로 돌아갑니다.")
                            continue
                        }
                    } catch (e: NumberFormatException) {      // NumberFormatException을 이용해서 서브 메뉴 번호로 숫자가 아닌 문자를 입력했을 때의 경우를 예외 처리
                        println("숫자가 아닌 것은 서브 메뉴 번호로 입력할 수 없습니다. 처음으로 돌아갑니다.")
                        continue
                    }
                } 3 -> {
                    println("[ Drinks MENU ]")
                    var count = 1
                    for (i in menuName.indices) {
                        val drink = SubMenu(menuName[2][i], menuPrice[2][i], menuComment[3][i], count)
                        drink.menu()
                        count++
                    }
                    println("0. 뒤로 가기   |   뒤로 가기")
                    try {
                        print("서브 메뉴 번호를 입력하세요. 메인 메뉴로 돌아가려면 0을 입력하세요. : ")
                        val subMenuNumber = readLine()!!.toInt()
                        if (subMenuNumber == 0) continue else if (subMenuNumber in 1..4) {
                            println("잘못된 서브 메뉴 번호입니다. 처음으로 돌아갑니다.")
                            continue
                        } else {
                            println("입력한 숫자가 서브 메뉴 번호 범위를 벗어납니다. 처음으로 돌아갑니다.")
                            continue
                        }
                    } catch (e: NumberFormatException) {      // NumberFormatException을 이용해서 서브 메뉴 번호로 숫자가 아닌 문자를 입력했을 때의 경우를 예외 처리
                        println("숫자가 아닌 것은 서브 메뉴 번호로 입력할 수 없습니다. 처음으로 돌아갑니다.")
                        continue
                    }
                } 4 -> {
                    println("[ Beer MENU ]")
                    var count = 1
                    for (i in menuName.indices) {
                        val beer = SubMenu(menuName[3][i], menuPrice[3][i], menuComment[4][i], count)
                        beer.menu()
                        count++
                    }
                    println("0. 뒤로 가기   |   뒤로 가기")
                    try {
                        print("서브 메뉴 번호를 입력하세요. 메인 메뉴로 돌아가려면 0을 입력하세요. : ")
                        val subMenuNumber = readLine()!!.toInt()
                        if (subMenuNumber == 0) continue else if (subMenuNumber in 1..4) {
                            println("잘못된 서브 메뉴 번호입니다. 처음으로 돌아갑니다.")
                            continue
                        } else {
                            println("입력한 숫자가 서브 메뉴 번호 범위를 벗어납니다. 처음으로 돌아갑니다.")
                            continue
                        }
                    } catch (e: NumberFormatException) {      // NumberFormatException을 이용해서 서브 메뉴 번호로 숫자가 아닌 문자를 입력했을 때의 경우를 예외 처리
                        println("숫자가 아닌 것은 서브 메뉴 번호로 입력할 수 없습니다. 처음으로 돌아갑니다.")
                        continue
                    }
                } 0 -> {
                    println("0을 입력하였으므로 키오스크 프로그램을 종료합니다.")      // 메인 메뉴판에서 메인 메뉴 번호로 0을 입력했을 때 프로그램 종료
                    break
                } else -> {
                    println("입력한 숫자가 메인 메뉴 번호 범위를 벗어납니다. 다시 입력하세요.")          // 메인 메뉴판에서 메인 메뉴 번호로 0~4 범위 이외의 숫자를 입력했을 때 다시 처음부터 다시 입력하도록 설정
                    continue
                }
            }
        } catch (e:NumberFormatException) {    // 메인 메뉴판에서 메뉴 번호로 문자를 입력했을 때에 대한 예외를 처리
            println("숫자가 아닌 것은 메인 메뉴 번호로 입력할 수 없습니다. 다시 입력하세요.")
            continue
        }
    }
}