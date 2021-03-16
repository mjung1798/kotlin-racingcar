package racingcar.ui

object InputView {

    tailrec fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: getNumberOfCars()
    }

    tailrec fun getTryCounts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: getTryCounts()
    }
}
