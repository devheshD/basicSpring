package develop.basicSpring.member.service

import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: String): Member?
}
