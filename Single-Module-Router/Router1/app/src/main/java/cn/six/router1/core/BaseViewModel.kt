package cn.six.router1.core

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    val disposables = CompositeDisposable()

    override fun onCleared() {
        println("szwl vm.onCleared() <- ${this::class.simpleName}")
        super.onCleared()
        disposables.dispose()
    }
}