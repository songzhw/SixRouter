package ca.six.router.library

import android.app.Activity

/*
 1. Precondition: 想跳A. 但若是条件precondition不满足, 就会跳到B.(不会跳到A)
 2. Enpower: 想跳A, 但要求先登录(比如说). 这样先登录, 登录完后再跳到A.\

 顺序上是: 先检测enpower, 符合条件了再检测precondition.
 */
class Station(var target: String, val clazz: Class<out Activity>) {

    val preconditionList: ArrayList<Precondition> = arrayListOf()

    fun addPrecondition(precondition: Precondition) {
        preconditionList.add(precondition)
    }
}

