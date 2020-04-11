package ca.six.router.demo.common.biz.login

object ThisUser {
    private var me: User? = null

    fun setUser(user: User) {
        me = user
    }

    fun hasLoggedIn() = me != null
    fun isVip() = me?.isVip ?: false
    fun hasPaymentMethod() = me?.isPayment ?: false

    override fun toString(): String {
        return "ThisUser[name=${me?.name}]"
    }
}