package cn.six.router1.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.six.router1.core.router.Router
import cn.six.router1.core.router.Signpost
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

open class BaseFragment(val isLog: Boolean = false) : Fragment() {
    protected val router: Router by inject()
    protected val disposables: CompositeDisposable = CompositeDisposable()

    override fun onDetach() {
        super.onDetach()
        if (isLog) println("szwl frag.onDetach: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (isLog) println("szwl frag.onAttach: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isLog) println("szwl frag.onCreate: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isLog) println("szwl frag.onDestory: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (isLog) println("szwl frag.onCreateView: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isLog) println("szwl frag.onViewCreated: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (isLog) println("szwl frag.onDestroyView: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
        disposables.clear() //只清空, 不设置 isDisposed = true
        Signpost.currentFragment = ""
    }


    // Bug_C51_5282这个类会有个crash: 即30秒之后显示一个dialogFragment. 若这时从fragment已经跳到了另一个actv, 就会crash
    // 修复就在这里, 在onStop里就加一个clear
    override fun onStop() {
        super.onStop()
        disposables.clear()
        if (isLog) println("szwl frag.stop: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        if (isLog) println("szwl frag.start: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        if (isLog) println("szwl frag.resume: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
        Signpost.currentFragment = this.javaClass.simpleName
    }

    override fun onPause() {
        super.onPause()
        if (isLog) println("szwl frag.pause: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (isLog) println("szwl frag.onSaveInstanceState: ${this.javaClass.simpleName} -- ${this.lifecycle.currentState}")
    }
}