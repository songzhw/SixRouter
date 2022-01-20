package ca.six.router.demo.common.core.user

object UserSession {
    private var me: User? = null

    fun setUser(user: User?) {
        me = user
    }

    fun setPayMethods(pay: String?) {
        if (pay == null || pay == "") {
            me?.payMethods = null
            return
        }
        me?.payMethods?.add(pay)
    }

    fun hasLoggedIn() = me != null

    fun isVip() = me?.isVip ?: false

    fun hasPaymentMethod() = me?.payMethods?.isEmpty() ?: false

    override fun toString() = "ThisUser[name=${me?.name}]"

}