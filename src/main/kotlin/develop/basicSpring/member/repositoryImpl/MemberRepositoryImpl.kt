package develop.basicSpring.member.repositoryImpl

import develop.basicSpring.member.model.Member
import develop.basicSpring.member.repository.MemberRepository
import org.springframework.stereotype.Component

/**
 * @author Rasung Ki
 */
@Component
class MemberRepositoryImpl : MemberRepository {

    override fun save(member: Member) {
        store[member.memberId] = member
    }

    override fun findById(memberId: String): Member {
        return store[memberId]!!
    }

    companion object {
        private val store: HashMap<String, Member> = HashMap()
    }
}
