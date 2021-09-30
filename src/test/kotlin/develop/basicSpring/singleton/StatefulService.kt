package develop.basicSpring.singleton

import org.slf4j.LoggerFactory

/**
 * @author Rasung Ki
 */
class StatefulService {
    private val log = LoggerFactory.getLogger(javaClass)
    private var price: Int = 0

    fun order(name: String, price: Int) {
        log.info("name = $name, price = $price")
        this.price = price
    }

    fun getPrice() = price
}
