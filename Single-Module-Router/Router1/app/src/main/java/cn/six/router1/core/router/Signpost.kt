package cn.six.router1.core.router

object Signpost {
    var currentActivity: String = ""
    var currentFragment: String = ""

    override fun toString(): String {
        return "Signpost(currActv = $currentActivity,  currFrag = $currentFragment)"
    }
}