package ca.six.router.demo.common.core.user

// username could be 'vipay", "nopay", "normal", ...
data class User(
    val name: String,
    val isVip: Boolean,
    val payMethods: ArrayList<String>? = null
)
