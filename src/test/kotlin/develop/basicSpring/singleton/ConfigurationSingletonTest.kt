package develop.basicSpring.singleton

import develop.basicSpring.AppConfig
import develop.basicSpring.member.repository.MemberRepository
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import develop.basicSpring.order.serviceImpl.OrderServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
class ConfigurationSingletonTest {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun configurationTest() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        val orderService = ac.getBean("orderService", OrderServiceImpl::class.java)
        val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

        val memberRepository1 = memberService.getMemberRepository()
        val memberRepository2 = orderService.getMemberRepository()

        log.info("memberService -> memberRepository = $memberRepository1")
        log.info("orderService -> memberRepository = $memberRepository2")
        log.info("memberRepository = $memberRepository")

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository)
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository)
    }

    @Test
    fun configurationDeep() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
        val bean = ac.getBean(AppConfig::class.java)

        log.info("bean = ${bean.javaClass}")
    }
}
