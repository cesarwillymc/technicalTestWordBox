package com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.remote


import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.SourcePeopleDataGenerator.errorData
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.SourcePeopleDataGenerator.peopleRandom
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.framework.PeopleService
import com.cesarwillymc.technicaltestwordbox.extension.ONE
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
class PeopleRemoteDataSourceImplTest {

    @RelaxedMockK
    lateinit var service: PeopleService

    lateinit var remoteDataSource: PeopleRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        remoteDataSource = PeopleRemoteDataSourceImpl(service = service)
    }

    @Test
    fun getRandomPeopleSuccess() = runTest {
        coEvery { service.getRandomPeople() } returns peopleRandom

        val result = remoteDataSource.getRandomPeople()

        coVerify(exactly = ONE) { service.getRandomPeople() }
        Assert.assertTrue(result.isSuccess)
        result.getData().results.firstOrNull().let {
            Assert.assertEquals(it?.email, peopleRandom.results.firstOrNull()?.email)
            Assert.assertEquals(it?.id, peopleRandom.results.firstOrNull()?.id)
        }
    }

    @Test
    fun getRandomPeopleError() = runTest {
        coEvery { service.getRandomPeople() } throws errorData

        val result = remoteDataSource.getRandomPeople()

        coVerify(exactly = ONE) { service.getRandomPeople() }

        Assert.assertTrue(result.isError)
    }
}