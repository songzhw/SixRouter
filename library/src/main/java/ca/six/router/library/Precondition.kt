package ca.six.router.library

class Precondition(
    val precondition: () -> Boolean,
    val succStation: String,
    val failStation: String
)