package com.ijniclohot.dependency_injection

import com.ijniclohot.networking.Networking
import org.koin.dsl.module

val appModules = module {
    single { Networking.apiService }
}