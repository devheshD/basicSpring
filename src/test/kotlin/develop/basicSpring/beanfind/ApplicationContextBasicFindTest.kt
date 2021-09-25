package develop.basicSpring.beanfind

import develop.basicSpring.AppConfig
import develop.basicSpring.member.service.MemberService
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
class ApplicationContextBasicFindTest {

    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun `빈 이름으로 조회`() {
        val memberService = applicationContext.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `이름 없이 타입으로만 조회`() {
        val memberService = applicationContext.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `구현체 타입으로 조회`() {
        val memberServiceImpl = applicationContext.getBean("memberService", MemberServiceImpl::class.java)
        assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `빈 이름으로 조회 X`() {
        assertThrows(NoSuchBeanDefinitionException::class.java) { applicationContext.getBean("xxx", MemberService::class.java) }
    }

}
