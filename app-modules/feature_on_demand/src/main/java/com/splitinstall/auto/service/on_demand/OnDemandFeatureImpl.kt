package com.splitinstall.auto.service.on_demand

import android.content.Context
import androidx.annotation.Keep
import com.app.logger.Logger
import com.auto.service.ImplementationOf
import com.splitinstall.auto.service.longToast

@Keep
@ImplementationOf(OnDemandFeature::class)
class OnDemandFeatureImpl(context: Context, private val logger: Logger) : OnDemandFeature {
    override fun doSomeThing(text: String) {
        longToast("$text.OnDemandProviderImpl.doSomeThing()")
    }

//    class StorageFeatureProviderImpl : OnDemandFeature.Provider {
//        override fun get(dependencies: OnDemandFeature.Dependencies): OnDemandFeature {
//            return OnDemandFeatureImpl(dependencies.getContext(), dependencies.getLogger())
//        }
//    }
}