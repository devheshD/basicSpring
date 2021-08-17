package develop.basicSpring.member.repositoryImpl

import develop.basicSpring.member.Member
import develop.basicSpring.member.repository.MemberRepository
import develop.basicSpring.member.repository.MemberService

/**
 * @author Rasung Ki
 */
class MemberServiceImpl(
    private val memberRepository: MemberRepository
): MemberService {
    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: String): Member? {
        return memberRepository.findById(memberId)
    }
}
