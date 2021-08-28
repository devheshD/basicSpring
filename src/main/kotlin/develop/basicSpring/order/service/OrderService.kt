package develop.basicSpring.order.service

import develop.basicSpring.order.model.Order

/**
 * @author Rasung Ki
 */
interface OrderService {
    fun createOrder(memberId: String, itemName: String, itemPrice: Int): Order
}
