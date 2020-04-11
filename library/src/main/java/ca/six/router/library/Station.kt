package ca.six.router.library

import android.app.Activity

class Station(var target: String, val clazz: Class<out Activity>) {

    var precondition: (() -> Boolean)? = null

    fun setPrecondition(precondition: () -> Boolean): Station {
        this.precondition = precondition
        return this
    }

    fun setOnPreconditionFail(targetForFailure: String): Station {
        target = targetForFailure
        return this
    }

}
