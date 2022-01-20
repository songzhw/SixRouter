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
        if (me == null) {
            return
        }
        if (me!!.payMethods == null) {
            me!!.payMethods = ArrayList<String>()
        }
        me!!.payMethods?.add(pay)
    }

    fun hasLoggedIn() = me != null

    fun isVip() = me?.isVip ?: false

    fun hasPaymentMethod() : Boolean {
        if (me == null) return false;
        if (me!!.payMethods == null) return false;
        return !me!!.payMethods!!.isEmpty()
    }

    override fun toString() = "ThisUser[name=${me?.name}]"

}