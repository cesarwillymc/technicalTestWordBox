package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
interface PeopleDataMapper {
    fun responseToDomain(info: PeopleRandomResponse): List<Person>
}
