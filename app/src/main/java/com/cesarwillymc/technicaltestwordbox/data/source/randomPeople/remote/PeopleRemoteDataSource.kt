package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote

import com.cesarwillymc.technicaltestwordbox.extension.Result
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
interface PeopleRemoteDataSource {
    suspend fun getRandomPeople(): Result<PeopleRandomResponse>
}
