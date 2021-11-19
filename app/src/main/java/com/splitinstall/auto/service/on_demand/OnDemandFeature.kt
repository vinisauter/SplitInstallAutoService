package com.splitinstall.auto.service.on_demand

import android.content.Context
import androidx.annotation.Keep
import com.app.logger.Logger
import com.auto.service.dynamic.FromModule

@Keep
@FromModule("feature_on_demand")
interface OnDemandFeature {
    fun doSomeThing(text: String)


//    /**
//     * StorageFeature can be instantiated in whatever way the implementer chooses,
//     * we just want to have a simple method to get() an instance of it.
//     */
//    interface Provider {
//        fun get(dependencies: Dependencies): OnDemandFeature
//    }
//
//    /**
//     * Dependencies from the main app module that are required by the StorageFeature.
//     */
//    interface Dependencies {
//        fun getContext(): Context
//        fun getLogger(): Logger
//    }
}