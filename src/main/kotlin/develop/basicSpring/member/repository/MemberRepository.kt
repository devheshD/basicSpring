package develop.basicSpring.member.repository

import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
interface MemberRepository {
    fun save(member: Member)
    fun findById(memberId: String): Member
}
