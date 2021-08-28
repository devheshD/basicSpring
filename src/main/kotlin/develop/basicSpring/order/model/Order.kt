package develop.basicSpring.order.model

/**
 * @author Rasung Ki
 */
data class Order(
    val memberId: String,
    val itemName: String,
    val itemPrice: Int,
    val discountPrice: Int,
) {
    fun calculatePrice(): Int {
        return itemPrice - discountPrice
    }

}
