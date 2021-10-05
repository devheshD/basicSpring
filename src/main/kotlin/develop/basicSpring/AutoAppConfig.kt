package develop.basicSpring

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

/**
 * @author Rasung Ki
 */
@Configuration
@ComponentScan(
    basePackages = ["develop.basicSpring"],
    excludeFilters = [Filter(type = FilterType.ANNOTATION, classes = arrayOf(Configuration::class))]
)
class AutoAppConfig {

}
