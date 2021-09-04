package develop.basicSpring

import develop.basicSpring.discount.DiscountPolicy
import develop.basicSpring.discount.FixDiscountPolicy
import develop.basicSpring.discount.RateDiscountPolicy
import develop.basicSpring.member.repository.MemberRepository
import develop.basicSpring.member.repositoryImpl.MemberRepositoryImpl
import develop.basicSpring.member.service.MemberService
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import develop.basicSpring.order.service.OrderService
import develop.basicSpring.order.serviceImpl.OrderServiceImpl

/**
 * @author Rasung Ki
 */
class AppConfig {

    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    private fun memberRepository(): MemberRepository {
        return MemberRepositoryImpl()
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

    private fun discountPolicy(): DiscountPolicy {
//        return RateDiscountPolicy()
        return  FixDiscountPolicy()
    }

}
