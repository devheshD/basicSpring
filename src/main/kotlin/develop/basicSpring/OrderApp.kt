package develop.basicSpring

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
fun main() {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()
    val member = Member("1", "memberA", Grade.VIP)

    memberService.join(member)

    val order = orderService.createOrder(
        memberId = "1",
        itemName = "itemA",
        itemPrice = 20000,
    )

    println("order = $order")
    println("order = ${order.calculatePrice()}")

}
