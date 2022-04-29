package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.People
import com.cesarwillymc.technicaltestwordbox.extension.FORMAT_TWO_STRING
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 11/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class PeopleDataMapperImpl @Inject constructor() :
    PeopleDataMapper {
    override fun responseToDomain(info: PeopleRandomResponse): List<People> {
        return info.results.map {
            People(
                name = FORMAT_TWO_STRING.format(it.name.first, it.name.last),
                id = it.id.value,
                photo = it.picture.thumbnail,
                email = it.email,
                gender = it.gender,
                age = it.dob.age,
                country = it.location.country
            )
        }
    }

}
