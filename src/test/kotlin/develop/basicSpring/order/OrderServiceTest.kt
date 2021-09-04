package develop.basicSpring.order

import develop.basicSpring.AppConfig
import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author Rasung Ki
 */
class OrderServiceTest {
    private val appConfig = AppConfig()
    private val memberService = appConfig.memberService()
    private val orderService = appConfig.orderService()

    @Test
    fun createOrder() {
        val memberId = "1"
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}
