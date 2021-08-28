package develop.basicSpring.member.repositoryImpl

import develop.basicSpring.member.model.Member
import develop.basicSpring.member.repository.MemberRepository

/**
 * @author Rasung Ki
 */
class MemberRepositoryImpl {
    val memberRepository = object : MemberRepository {
        override fun save(member: Member) {
            store[member.memberId] = member
        }

        override fun findById(memberId: String): Member? {
            return store[memberId]
        }
    }

    companion object {
        private val store: HashMap<String, Member> = HashMap()
    }

}
