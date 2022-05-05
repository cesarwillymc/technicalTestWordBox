package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Dob
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Id
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Info
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Location
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Name
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.PeopleRandomResponse
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Picture
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Registered
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.entities.Result

/**
 * Created by cesarwillymamanicanaza on 4/05/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
object SourcePeopleDataGenerator {
    val peopleRandom = PeopleRandomResponse(
        info = Info(1, 1, "any", "1"),
        results = listOf(
            Result(
                cell = "962601310",
                dob = Dob(23, "11/10/3030"),
                email = "cesarwilly.mc@gmail.com",
                gender = "male",
                id = Id("name", "213123dc"),
                location = Location("puno", "Peru"),
                name = Name("cesar", "mamani canaza", "cesar mamani canaza"),
                nat = "213123",
                phone = "962601310",
                picture = Picture("large", "mediun", "www.google.com"),
                registered = Registered(23, "23/10/3030")
            )
        )
    )

    val errorData = Exception("Sucedio un error")
}