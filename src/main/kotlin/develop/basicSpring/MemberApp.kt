package develop.basicSpring

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import develop.basicSpring.member.serviceImpl.MemberServiceImpl

/**
 * @author Rasung Ki
 */
fun main() {
    val member = Member("1", "memberA", Grade.VIP)
    val service = MemberServiceImpl()
    service.join(member)

    val findMember = service.findMember("1")

    println("Find Member = ${findMember?.name}")
    println("Member = ${member.name}")

}
