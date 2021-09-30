package develop.basicSpring.singleton

import develop.basicSpring.AppConfig
import develop.basicSpring.member.service.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
class SingletonTest {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun `스프링 없는 순수한 DI 컨테이너`() {
        val appConfig = AppConfig()
        val memberService1 = appConfig.memberService()
        val memberService2 = appConfig.memberService()
        // 다수의 사용자가 memberService를 요청할 때마다 새로운 객체가 생성되며 메모리에 올라가게 된다.
        log.info("memberService1 : $memberService1")
        log.info("memberService2 : $memberService2")

        Assertions.assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    fun `싱글턴 패턴을 적용한 객체 사용`() {
        val singletonService1 = SingletonService.getInstance()
        val singletonService2 = SingletonService.getInstance()

        log.info("singletonService1 : $singletonService1")
        log.info("singletonService2 : $singletonService2")
        // singletonService1 == singletonService2
        Assertions.assertThat(singletonService1).isSameAs(singletonService2)

    }

    @Test
    fun `스프링 컨테이너와 싱글턴`() {
        val appConfig = AnnotationConfigApplicationContext(AppConfig::class.java)
        val memberService1 = appConfig.getBean("memberService", MemberService::class.java)
        val memberService2 = appConfig.getBean("memberService", MemberService::class.java)

        log.info("memberService1 : $memberService1")
        log.info("memberService2 : $memberService2")

        Assertions.assertThat(memberService1).isSameAs(memberService2)
    }
}
