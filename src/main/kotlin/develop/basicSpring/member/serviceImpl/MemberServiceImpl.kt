package develop.basicSpring.member.serviceImpl

import develop.basicSpring.member.Member
import develop.basicSpring.member.repositoryImpl.MemberRepositoryImpl
import develop.basicSpring.member.service.MemberService

/**
 * @author Rasung Ki
 */
class MemberServiceImpl(
    private val memberRepo: MemberRepositoryImpl = MemberRepositoryImpl()
) {
    // MemberService memeberService = new MemberService (Interface)
    val memberService = object : MemberService {
        override fun join(member: Member) {
            memberRepo.memberRepository.save(member)
        }

        override fun findMember(memberId: String): Member? {
            return memberRepo.memberRepository.findById(memberId)
        }
    }

}
