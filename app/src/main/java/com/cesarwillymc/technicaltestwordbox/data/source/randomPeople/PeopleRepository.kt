package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper.PeopleDataMapper
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote.PeopleRemoteDataSource
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.extension.Result
import com.cesarwillymc.technicaltestwordbox.extension.map
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class PeopleRepository @Inject constructor(
    private val remoteDataSource: PeopleRemoteDataSource,
    private val mapper: PeopleDataMapper,
) : PeopleDataSource {
    override suspend fun getRandomPeople(): Result<List<Person>> {
        return remoteDataSource.getRandomPeople().map(mapper::responseToDomain)
    }

}
