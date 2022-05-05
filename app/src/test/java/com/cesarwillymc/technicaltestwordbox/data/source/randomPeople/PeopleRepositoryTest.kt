package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople

import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper.PeopleDataMapper
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.mapper.PeopleDataMapperImpl
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote.PeopleRemoteDataSource
import com.cesarwillymc.technicaltestwordbox.extension.ONE
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
class PeopleRepositoryTest {

    @RelaxedMockK
    lateinit var remoteDataSource: PeopleRemoteDataSource

    lateinit var mapper: PeopleDataMapper
    lateinit var repository: PeopleDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mapper = PeopleDataMapperImpl()
        repository = PeopleRepository(remoteDataSource = remoteDataSource, mapper = mapper)
    }

    @Test
    fun getRandomPeopleSuccess() = runTest {
        coEvery { remoteDataSource.getRandomPeople() } returns Result.Success(
            SourcePeopleDataGenerator.peopleRandom
        )

        val result = repository.getRandomPeople()

        coVerify(exactly = ONE) { remoteDataSource.getRandomPeople() }
        Assert.assertTrue(result.isSuccess)
        result.getData().firstOrNull().let {
            Assert.assertEquals(
                it?.email,
                SourcePeopleDataGenerator.peopleRandom.results.firstOrNull()?.email
            )
            Assert.assertEquals(
                it?.id,
                SourcePeopleDataGenerator.peopleRandom.results.firstOrNull()?.id?.value
            )
        }
    }

    @Test
    fun getRandomPeopleError() = runTest {
        coEvery { remoteDataSource.getRandomPeople() } returns Result.Error(
            SourcePeopleDataGenerator.errorData
        )

        val result = repository.getRandomPeople()

        coVerify(exactly = ONE) { remoteDataSource.getRandomPeople() }
        Assert.assertTrue(result.isError)
        result.getError().let {
            Assert.assertEquals(it.message, SourcePeopleDataGenerator.errorData.message)
        }
    }
}