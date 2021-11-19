package com.splitinstall.auto.service

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.injectViewModel
import androidx.lifecycle.lifecycleScope
import com.auto.service.dynamic.SplitInstall
import com.auto.service.dynamic.SplitInstallMonitor
import com.auto.service.load
import com.splitinstall.auto.service.databinding.ActivityMainBinding
import com.splitinstall.auto.service.install_time.InstallTimeProvider
import com.splitinstall.auto.service.on_demand.OnDemandFeature

class MainActivity : AppCompatActivity() {

    private val bind: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

//    //empty constructor
//    private val viewModel: MainViewModel by viewModels()
//
//    //constructor with parameters
//    private val viewModel: MainViewModel by viewModels {
//        CustomViewModelFactory(
//            application,
//            this,
//            intent?.extras
//        )
//    }

    //constructor with parameters by inject
    private val viewModel: MainViewModel by injectViewModel()//InjectionViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        installTimeDoSomeThing()
        onDemandDoSomeThing()
        viewModel.doSomeThing()

        lifecycleScope
    }

    private fun installTimeDoSomeThing() {
        // if you ensure that module is already installed
        val installTime = load<InstallTimeProvider>()
        installTime.doSomeThing("MainActivity")
    }

    private fun onDemandDoSomeThing() {
        SplitInstall(this).install("feature_on_demand",
            this, object : SplitInstall.ObserverSplitInstallSessionState {
                override fun onCanceled(state: SplitInstallMonitor) {
                    longToast("MainActivity.install.onCanceled(${state})")
                }

                override fun onFailed(state: SplitInstallMonitor) {
                    longToast("MainActivity.install.onFailed(${state.exception?.message})")
                }

                override fun onInstalled(state: SplitInstallMonitor) {
                    val onDemand = load<OnDemandFeature>()
                    onDemand.doSomeThing("MainActivity")
                }
            })
    }
}