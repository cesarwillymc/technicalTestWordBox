package com.cesarwillymc.technicaltestwordbox.domain.usecase.people

import com.cesarwillymc.technicaltestwordbox.extension.Result
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.PeopleDataSource
import com.cesarwillymc.technicaltestwordbox.data.util.coroutine.IoDispatcher
import com.cesarwillymc.technicaltestwordbox.domain.base.SuspendUseCase
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.People
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 12/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class GetPeopleRandomUseCase @Inject constructor(
    private val repository: PeopleDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : SuspendUseCase<Unit, List<People>>(
    coroutineDispatcher = dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<List<People>> {
        return repository.getRandomPeople()
    }
}
