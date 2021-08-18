package develop.basicSpring

import develop.basicSpring.member.Grade
import develop.basicSpring.member.Member
import develop.basicSpring.member.serviceImpl.MemberServiceImpl

/**
 * @author Rasung Ki
 */
fun main() {
    val member = Member("1", "memberA", Grade.VIP)
    val service = MemberServiceImpl()
    service.memberService.join(member)

    val findMember = service.memberService.findMember("1")

    println("Find Member = ${findMember?.name}")
    println("Member = ${member.name}")
}
