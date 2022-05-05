package com.cesarwillymc.technicaltestwordbox.domain.usecase.people

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.PeopleDataSource
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.GetPeopleDataGenerator.errorData
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.GetPeopleDataGenerator.listPeople
import com.cesarwillymc.technicaltestwordbox.extension.ONE
import com.cesarwillymc.technicaltestwordbox.extension.ONE_FLOAT
import com.cesarwillymc.technicaltestwordbox.extension.Result
import com.cesarwillymc.technicaltestwordbox.extension.getData
import com.cesarwillymc.technicaltestwordbox.extension.getError
import com.cesarwillymc.technicaltestwordbox.extension.isError
import com.cesarwillymc.technicaltestwordbox.extension.isSuccess
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by cesarwillymamanicanaza on 4/05/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@ExperimentalCoroutinesApi
class GetPeopleRandomUseCaseTest {

    @RelaxedMockK
    lateinit var repository: PeopleDataSource

    lateinit var useCase: GetPeopleRandomUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetPeopleRandomUseCase(repository, UnconfinedTestDispatcher())
    }

    @Test
    fun executeSuccess() = runTest {
        coEvery { repository.getRandomPeople() } returns Result.Success(listPeople)

        val result = useCase(Unit)

        coVerify(exactly = ONE) { repository.getRandomPeople() }
        Assert.assertTrue(result.isSuccess)
        Assert.assertEquals(result.getData().firstOrNull()?.email, listPeople.firstOrNull()?.email)
        Assert.assertEquals(result.getData().firstOrNull()?.id, listPeople.firstOrNull()?.id)
    }

    @Test
    fun executeError() = runTest {
        coEvery { repository.getRandomPeople() } returns Result.Error(errorData)

        val result = useCase(Unit)

        coVerify(exactly = ONE) { repository.getRandomPeople() }
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.getError().message, errorData.message)
    }
}