package develop.basicSpring.scan

import develop.basicSpring.AutoAppConfig
import develop.basicSpring.member.service.MemberService
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
class AutoAppConfigTest {
    private val log = LoggerFactory.getLogger(javaClass)
    @Test
    fun basicScan() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)
        val memberService = ac.getBean(MemberService::class.java)

        assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}
