package develop.basicSpring.order.serviceImpl

import develop.basicSpring.discount.DiscountPolicy
import develop.basicSpring.discount.FixDiscountPolicy
import develop.basicSpring.discount.RateDiscountPolicy
import develop.basicSpring.member.repositoryImpl.MemberRepositoryImpl
import develop.basicSpring.order.model.Order
import develop.basicSpring.order.service.OrderService

/**
 * @author Rasung Ki
 */
class OrderServiceImpl : OrderService {

    private val memberRepository = MemberRepositoryImpl()
//    private val discountPolicy = FixDiscountPolicy()
    private val discountPolicy = RateDiscountPolicy()

    override fun createOrder(memberId: String, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
