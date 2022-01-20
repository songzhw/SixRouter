package ca.six.router.demo.common.core.user

object UserSession {
    private var me: User? = null

    fun setUser(user: User) {
        me = user
    }

    fun hasLoggedIn() = me != null

    fun isVip() = me?.isVip ?: false

    fun hasPaymentMethod() = me?.payMethods?.isEmpty() ?: false

    override fun toString() = "ThisUser[name=${me?.name}]"

}