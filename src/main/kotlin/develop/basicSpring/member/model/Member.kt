package develop.basicSpring.member.model

import develop.basicSpring.member.Grade

/**
 * @author Rasung Ki
 */
data class Member(
    val memberId: String,
    val name: String,
    val grade: Grade,
)
