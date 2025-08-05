package cn.six.router1.core.router

interface ISubRoute {
    fun registerSubRoute(map: HashMap<String, RouteMeta>)
}