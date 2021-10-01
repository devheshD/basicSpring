package develop.basicSpring.order.serviceImpl

import develop.basicSpring.discount.DiscountPolicy
import develop.basicSpring.member.repository.MemberRepository
import develop.basicSpring.order.model.Order
import develop.basicSpring.order.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author Rasung Ki
 */
@Component
class OrderServiceImpl @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy,
) : OrderService {

    override fun createOrder(memberId: String, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    // 테스트 용도
    fun getMemberRepository() = memberRepository
}
