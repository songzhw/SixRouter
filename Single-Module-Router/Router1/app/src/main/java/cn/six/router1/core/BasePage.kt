package cn.six.router1.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.six.router1.core.router.Signpost
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.SerialDisposable

open class BasePage : AppCompatActivity {
    var isLog =
        false // 'val' on secondary constructor parameter is not allowed. 所以只能自己写this.x = x了.

    // 支持两种构造函数
    constructor() : super()
    constructor(resId: Int) : super(resId)
    constructor(isLog: Boolean = false) : super() {
        this.isLog = isLog; }

    val disposables: CompositeDisposable = CompositeDisposable()
    protected val serialDisposables: SerialDisposable = SerialDisposable()

    override fun onDestroy() {
        disposables.dispose()
        serialDisposables.dispose()
        super.onDestroy()
        if (isLog) println("szwl actv.destroy: ${this.javaClass.simpleName}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isLog) println("szwl actv.create: ${this.javaClass.simpleName}")
    }


    override fun onStop() {
        super.onStop()
        disposables.clear() // 可以clear多次, 但只能dispose一次!
        if (isLog) println("szwl actv.stop: ${this.javaClass.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        if (isLog) println("szwl actv.start: ${this.javaClass.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        if (isLog) println("szwl actv.resume: ${this.javaClass.simpleName}")

        Signpost.currentActivity = this.javaClass.simpleName
        //如果是从一个多Frag的Actv, 退回到一个无Frag的Actv, 那原来frag的记录也要清空
        val fs = this.supportFragmentManager.fragments
        if (fs.size == 0) {
            Signpost.currentFragment = ""
        }

    }

    override fun onPause() {
        super.onPause()
        if (isLog) println("szwl actv.pause: ${this.javaClass.simpleName}")
    }

    // Fragment在此方法之后不能再更新UI了, 所以有时我也要知道这方法有没有被执行, 所以要加个log
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (isLog) println("szwl actv.onSaveInstanceState: ${this.javaClass.simpleName}")
    }
}

/*
1. actv1跳另一actv2, 那actv1的以下方法会被调用
    : onPause, onStop, onSaveInstanceState
这一点很重要, 是因为More5282Page1在先点btn1再马上点btn3, 果然5秒后crash了:
" Caused by: java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState"


 */