package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.framework

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse
import com.cesarwillymc.technicaltestwordbox.extension.DEFAULT_RANDOM_PEOPLE
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Willy on 15/12/2021.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
interface PeopleService {

    @GET(BASE_URL)
    suspend fun getRandomPeople(
        @Query(RANDOM) results: Int = DEFAULT_RANDOM_PEOPLE
    ): PeopleRandomResponse

    companion object {
        private const val BASE_URL = "api/"
        const val RANDOM = "results"
    }
}
