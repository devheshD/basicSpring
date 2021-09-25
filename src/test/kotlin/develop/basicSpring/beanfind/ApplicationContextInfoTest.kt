package develop.basicSpring.beanfind

import develop.basicSpring.AppConfig
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Rasung Ki
 */
class ApplicationContextInfoTest {

    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun `모든 빈 출력`() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val bean = applicationContext.getBean(beanDefinitionName)
            log.info("name = ${beanDefinitionName}, object = $bean" )
        }
    }

    @Test
    fun `애플리케이션 빈 출력`() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName)
            // 내부에서 등록한 빈이 아니라 내가 애플리케이션으로 개발을 위해 등록한 빈
            // ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                val bean = applicationContext.getBean(beanDefinitionName)
                log.info("name = ${beanDefinitionName}, object = $bean" )
            }
        }
    }

    // iter + tab
}
