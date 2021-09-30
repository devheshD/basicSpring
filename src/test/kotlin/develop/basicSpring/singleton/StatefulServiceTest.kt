package develop.basicSpring.singleton

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

/**
 * @author Rasung Ki
 */
class StatefulServiceTest {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun statefulServiceSingleton() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)
        val statefulService1 = ac.getBean(StatefulService::class.java)
        val statefulService2 = ac.getBean(StatefulService::class.java)

        // ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000)
        // ThreadB : B사용자 20000원 주문
        statefulService2.order("userB", 20000)

        // ThreadA : 사용자A 주문 금액 조회
        val price = statefulService1.getPrice()
        log.info("price = $price")

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000)

    }

    companion object {
        class TestConfig {

            @Bean
            fun statefulService() = StatefulService()
        }
    }

}
