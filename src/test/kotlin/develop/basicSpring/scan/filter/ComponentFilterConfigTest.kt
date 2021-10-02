package develop.basicSpring.scan.filter

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

/**
 * @author Rasung Ki
 */
class ComponentFilterConfigTest {
    @Test
    fun filterScan() {
        val ac = AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)
        val beanA = ac.getBean("beanA", BeanA::class.java)
        assertThat(beanA).isNotNull

        assertThrows(NoSuchBeanDefinitionException::class.java) {
            ac.getBean("beanB", BeanB::class.java)
        }
    }

    companion object {
        @Configuration
        @ComponentScan(
            includeFilters = [Filter(type = FilterType.ANNOTATION, classes = arrayOf(MyIncludeComponent::class))],
            excludeFilters = [Filter(type = FilterType.ANNOTATION, classes = arrayOf(MyExcludeComponent::class))]
        )
        class ComponentFilterAppConfig
    }
}
