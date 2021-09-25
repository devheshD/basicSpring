package develop.basicSpring.beanfind

import develop.basicSpring.discount.DiscountPolicy
import develop.basicSpring.discount.FixDiscountPolicy
import develop.basicSpring.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Rasung Ki
 */
class ApplicationContextExtendsFindTest {

    private val applicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    fun `부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류 발생`() {
        assertThrows<NoUniqueBeanDefinitionException> {
            applicationContext.getBean(DiscountPolicy::class.java)
        }
    }

    @Test
    fun `부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름 지정`() {
        val rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    fun `부모 타입으로 모두 조회`() {
        val beadsOfType = applicationContext.getBeansOfType(DiscountPolicy::class.java)
        assertThat(beadsOfType.size).isEqualTo(2)
    }

    @Configuration
    class TestConfig {
        @Bean
        fun rateDiscountPolicy(): DiscountPolicy {
            return RateDiscountPolicy()
        }

        @Bean
        fun fixDiscountPolicy(): DiscountPolicy {
            return FixDiscountPolicy()
        }
    }
}
