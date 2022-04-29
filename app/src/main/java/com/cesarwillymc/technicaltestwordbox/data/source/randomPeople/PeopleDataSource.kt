package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople

import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.extension.Result

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
interface PeopleDataSource {
    suspend fun getRandomPeople(): Result<List<Person>>
}
