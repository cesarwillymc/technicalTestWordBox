package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote


import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.framework.PeopleService
import com.cesarwillymc.technicaltestwordbox.data.util.BaseRemoteDataSource
import com.cesarwillymc.technicaltestwordbox.extension.Result
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class PeopleRemoteDataSourceImpl @Inject constructor(
    private val service: PeopleService
) : PeopleRemoteDataSource, BaseRemoteDataSource() {
    override suspend fun getRandomPeople(lat: Double, long: Double): Result<PeopleRandomResponse> {
        return getResult { service.getRandomPeople() }
    }

}
