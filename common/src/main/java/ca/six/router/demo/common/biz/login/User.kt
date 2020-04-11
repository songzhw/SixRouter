package ca.six.router.demo.common.biz.login

// username could be 'vipay", "nopay", "normal", ...
class User(val name: String) {
    val isVip: Boolean
        get() = name.contains("vip")
    val isPayment: Boolean
        get() = name.contains("pay")
}

