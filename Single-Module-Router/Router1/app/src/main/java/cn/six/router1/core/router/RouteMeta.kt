package cn.six.router1.core.router

import android.app.Activity

data class RouteMeta(
    var targetId: String,
    val clazz: Class<out Activity>,
    val bottomSheetMeta: BottomSheetMeta? = null,
)