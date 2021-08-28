package develop.basicSpring.member

import develop.basicSpring.member.model.Member
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import org.assertj.core.api.Assertions

import org.junit.jupiter.api.Test

/**
 * @author Rasung Ki
 */
class MemberServiceTest {

    private val memberServiceImpl = MemberServiceImpl()

    @Test
    fun join() {
        // given
        val member = Member("1", "memberA", Grade.VIP)
        // when
        memberServiceImpl.join(member)
        val findMember = memberServiceImpl.findMember("1")
        // then
        Assertions.assertThat(member).isEqualTo(findMember)

    }
}
