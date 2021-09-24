package develop.basicSpring

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import develop.basicSpring.member.service.MemberService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
fun main() {
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val service = applicationContext.getBean("memberService", MemberService::class.java)

    val member = Member("1", "memberA", Grade.VIP)
    service.join(member)

    val findMember = service.findMember("1")

    println("Find Member = ${findMember?.name}")
    println("Member = ${member.name}")

}
