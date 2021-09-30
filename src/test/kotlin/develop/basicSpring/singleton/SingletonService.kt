package develop.basicSpring.singleton

/**
 * @author Rasung Ki
 */
class SingletonService {

    companion object {
        private val instance = SingletonService()
        fun getInstance() = instance
    }
}
