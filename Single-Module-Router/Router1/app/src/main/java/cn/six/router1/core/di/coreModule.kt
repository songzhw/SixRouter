package cn.six.router1.core.di

import cn.six.router1.core.router.Router
import org.koin.dsl.module

val coreModule = module {
    single { Router() }
}