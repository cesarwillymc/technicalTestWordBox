package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.di

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.PeopleDataSource
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.PeopleRepository
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper.PeopleDataMapper
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper.PeopleDataMapperImpl
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote.PeopleRemoteDataSource
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote.PeopleRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RandomPeopleModule {

    @Binds
    abstract fun bindRepository(repository: PeopleRepository): PeopleDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: PeopleRemoteDataSourceImpl): PeopleRemoteDataSource

    @Binds
    abstract fun bindMapper(mapper: PeopleDataMapperImpl): PeopleDataMapper
}
