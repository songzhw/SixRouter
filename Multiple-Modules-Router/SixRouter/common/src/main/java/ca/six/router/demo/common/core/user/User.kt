package ca.six.router.demo.common.core.user

// username could be 'vipay", "nopay", "normal", ...
data class User(
    var name: String,
    var isVip: Boolean,
    var payMethods: ArrayList<String>? = null
)
