package develop.basicSpring.discount

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
class FixDiscountPolicy : DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) discountFixAmount
        else 0
    }
}
