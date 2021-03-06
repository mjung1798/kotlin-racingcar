package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import racingcar.history.RacingActionHistory

internal class CarCollectionTest {

    @Test
    @DisplayName("기준 숫자인 4이상의 값과 매칭되는 차는 이동한다")
    fun tryMoveCars() {
        val carCollection = CarCollection(listOf("jyami", "java", "spring"))
        carCollection.tryMoveCars(1, arrayListOf(0, 4, 8))

        val racingHistory = carCollection.getRacingHistories()[0].racingActionHistories

        assertThat(racingHistory).containsSequence(
            RacingActionHistory(0, "jyami"),
            RacingActionHistory(1, "java"),
            RacingActionHistory(1, "spring")
        )
    }

    @Test
    @DisplayName("자동차의 이동 위치를 이용해 승자를 구한다.")
    fun getWinner() {
        val carCollection = CarCollection(listOf("jyami", "java", "spring"))
        carCollection.tryMoveCars(1, arrayListOf(0, 10, 10))
        carCollection.tryMoveCars(1, arrayListOf(0, 10, 10))

        assertThat(carCollection.getWinner().map { it.userName }).contains("java", "spring")
    }
}
