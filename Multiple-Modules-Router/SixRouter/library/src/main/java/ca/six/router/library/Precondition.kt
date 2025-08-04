package ca.six.router.library

// precondition满足就直接继续往下走, 所以没有successStation这一参数了
class Precondition(
    val precondition: () -> Boolean,
    val destinationOnFail: String
)