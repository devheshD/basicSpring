package develop.basicSpring.order.model

/**
 * @author Rasung Ki
 */
data class Order(
    private val memberId: String,
    private val itemName: String,
    private val itemPrice: Int,
    private val discountPrice: Int,
) {
    fun calculatePrice(): Int {
        return itemPrice - discountPrice
    }
}
