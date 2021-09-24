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
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Rasung Ki
 */
@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return MemberRepositoryImpl()
    }

    @Bean
    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

    @Bean
    fun discountPolicy(): DiscountPolicy {
//        return RateDiscountPolicy()
        return  FixDiscountPolicy()
    }

}
