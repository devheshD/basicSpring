package develop.basicSpring.order

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import develop.basicSpring.order.serviceImpl.OrderServiceImpl

/**
 * @author Rasung Ki
 */
fun main() {
    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()
    val member = Member("1", "memberA", Grade.VIP)

    memberService.join(member)

    val order = orderService.createOrder(
        memberId = "1",
        itemName = "itemA",
        itemPrice = 10000,
    )

    println("order = $order")
    println("order = ${order.calculatePrice()}")

}
