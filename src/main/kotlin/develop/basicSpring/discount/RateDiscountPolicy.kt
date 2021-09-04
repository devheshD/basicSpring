package develop.basicSpring.discount

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
class RateDiscountPolicy: DiscountPolicy {
    private val discountPercent = 10;

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            price * discountPercent / 100
        } else {
            0
        }
    }
}
