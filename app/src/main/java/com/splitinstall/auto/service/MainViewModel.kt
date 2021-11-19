package com.splitinstall.auto.service

import android.app.Application
import androidx.lifecycle.*
import com.auto.service.dynamic.instance.splitDeferred
import com.auto.service.lazyLoad
import com.splitinstall.auto.service.install_time.InstallTimeProvider
import com.splitinstall.auto.service.on_demand.OnDemandFeature
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    app: Application,
    private val savedStateHandle: SavedStateHandle,

) : AndroidViewModel(app) {
    // if you ensure that module is already installed
    private val installTime by lazyLoad<InstallTimeProvider>()

    // if request module to be installed
    private val onDemandDeferred by splitDeferred<OnDemandFeature>(app)


//    private val onDemandDeferredStatus = SplitInstall(app).install("feature_on_demand").status

    init {
        viewModelScope.launch(Dispatchers.Default) {
            installTime.doSomeThing("MainViewModel")
            onDemandDeferred.await().doSomeThing("MainViewModel")
        }
    }

    fun doSomeThing() {
        longToast("MainViewModel.doSomeThing()")
    }
}