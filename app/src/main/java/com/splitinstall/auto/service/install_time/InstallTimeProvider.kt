package com.splitinstall.auto.service.install_time

import androidx.annotation.Keep
import com.auto.service.dynamic.FromModule

@Keep
@FromModule("feature_install_time")
interface InstallTimeProvider {
    fun doSomeThing(text: String)
}