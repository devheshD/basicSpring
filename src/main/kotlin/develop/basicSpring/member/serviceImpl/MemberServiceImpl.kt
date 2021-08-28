package develop.basicSpring.member.serviceImpl

import develop.basicSpring.member.model.Member
import develop.basicSpring.member.repositoryImpl.MemberRepositoryImpl
import develop.basicSpring.member.service.MemberService

/**
 * @author Rasung Ki
 */
class MemberServiceImpl(
    private val memberRepository: MemberRepositoryImpl = MemberRepositoryImpl()
) : MemberService {

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: String): Member? {
        return memberRepository.findById(memberId)
    }
}
