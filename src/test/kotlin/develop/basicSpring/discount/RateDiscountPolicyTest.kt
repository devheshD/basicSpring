package develop.basicSpring.discount

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Rasung Ki
 */
class RateDiscountPolicyTest {
    private val discountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10% 할인 적용 가능")
    fun applyDiscountVIP() {
        // given
        val member = Member("1", "memberVIP", Grade.VIP)
        // when
        val discount = discountPolicy.discount(member, 10000)
        // then
        assertThat(discount).isEqualTo(1000)
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인 적용 불가")
    fun notDiscountVIP() {
        // given
        val member = Member("2", "memberBASIC", Grade.BASIC)
        // when
        val discount = discountPolicy.discount(member, 10000)
        // then
        assertThat(discount).isEqualTo(0)
    }
}
