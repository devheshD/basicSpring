package develop.basicSpring.member.serviceImpl

import develop.basicSpring.member.model.Member
import develop.basicSpring.member.repository.MemberRepository
import develop.basicSpring.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author Rasung Ki
 */
@Component
class MemberServiceImpl @Autowired constructor(
    private val memberRepository: MemberRepository
) : MemberService {

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: String): Member? {
        return memberRepository.findById(memberId)
    }

    // 테스트 용도
    fun getMemberRepository() = memberRepository
}
