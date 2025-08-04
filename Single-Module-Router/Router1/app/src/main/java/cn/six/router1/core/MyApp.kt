package cn.six.router1.core

import android.app.Application
import cn.six.router1.core.di.bizModule
import cn.six.router1.core.di.coreModule
import cn.six.router1.core.router.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application()/*, ImageLoaderFactory*/ {
    protected val disposables: CompositeDisposable = CompositeDisposable()

    companion object {
        private lateinit var self: MyApp
        fun app(): MyApp = self
    }

    override fun onCreate() {
        super.onCreate()
        self = this

        startKoin {
            allowOverride(true)
            androidContext(this@MyApp)
            modules(coreModule, bizModule)
        }

        Router.init()

    }

    override fun onTerminate() {
        disposables.dispose()
        super.onTerminate()
    }


}