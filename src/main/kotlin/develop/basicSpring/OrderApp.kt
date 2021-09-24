package develop.basicSpring

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import develop.basicSpring.member.service.MemberService
import develop.basicSpring.order.service.OrderService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
fun main() {
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val orderService = applicationContext.getBean("orderService", OrderService::class.java)
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
