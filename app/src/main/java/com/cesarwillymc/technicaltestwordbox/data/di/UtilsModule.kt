package com.cesarwillymc.technicaltestwordbox.data.di

import com.cesarwillymc.technicaltestwordbox.data.util.network.ConnectionUtils
import com.cesarwillymc.technicaltestwordbox.data.util.network.ConnectionUtilsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by cesarwillymamanicanaza on 12/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {
    @Binds
    abstract fun bindStatusInternet(connection: ConnectionUtilsImpl): ConnectionUtils
}
