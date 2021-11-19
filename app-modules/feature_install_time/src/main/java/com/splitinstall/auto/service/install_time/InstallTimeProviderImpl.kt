package com.splitinstall.auto.service.install_time

import androidx.annotation.Keep
import com.auto.service.ImplementationOf
import com.splitinstall.auto.service.longToast

@Keep
@ImplementationOf(InstallTimeProvider::class)
class InstallTimeProviderImpl : InstallTimeProvider {
    override fun doSomeThing(text: String) {
        longToast("$text.InstallTimeProviderImpl.doSomeThing()")
    }
}