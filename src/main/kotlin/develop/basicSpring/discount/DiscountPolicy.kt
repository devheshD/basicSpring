package develop.basicSpring.discount

import develop.basicSpring.member.model.Member

/**
 * @author Rasung Ki
 */
interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    fun discount(member: Member, price: Int): Int
}
