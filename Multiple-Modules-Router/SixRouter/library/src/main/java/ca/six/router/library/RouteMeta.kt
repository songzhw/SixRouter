package ca.six.router.library

import android.app.Activity

class RouteMeta(var target: String, val clazz: Class<out Activity>) {

    val preconditionList: ArrayList<Precondition> = arrayListOf()

    fun addPrecondition(precondition: Precondition): RouteMeta {
        preconditionList.add(precondition)
        return this
    }

}

