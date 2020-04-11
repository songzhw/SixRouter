package ca.six.router.library

import android.app.Activity

/*
 1. Precondition: 想跳A. 但若是条件precondition不满足, 就会跳到B.(不会跳到A)
 2. Enpower: 想跳A, 但要求先登录(比如说). 这样先登录, 登录完后再跳到A.\

 顺序上是: 先检测enpower, 符合条件了再检测precondition.
 */
class Station(var target: String, val clazz: Class<out Activity>) {

    @JvmField
    var enpower = ""

    var precondition: (() -> Boolean)? = null

    fun setPrecondition(precondition: () -> Boolean): Station {
        this.precondition = precondition
        return this
    }

    // = = = = = = = = = = precondition = = = = = = = = = =
    fun setOnPreconditionFail(targetForFailure: String): Station {
        target = targetForFailure
        return this
    }

    // = = = = = = = = = =  enpower = = = = = = = = = =
    fun setEnpower(enpower: String): Station {
        this.enpower = enpower
        return this
    }

    fun getEnpower(): String {
        return enpower;
    }
}

