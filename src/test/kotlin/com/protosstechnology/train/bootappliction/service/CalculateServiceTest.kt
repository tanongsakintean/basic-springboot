package com.protosstechnology.train.bootappliction.service

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.protosstechnology.train.bootappliction.entity.User
import com.protosstechnology.train.bootappliction.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional
import kotlin.reflect.typeOf

@ExtendWith(SpringExtension::class)
class CalculateServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var calculateService: CalculateService

    @Test
    fun `should calculate complicated `() {
      val result =  calculateService.calculateNumber(1,2)
       Assertions.assertEquals(result,3)
    }


    @Test
    fun `should addUser test `() {
        val actual = User() // data mock

        actual.firstName = "test1"
        actual.lastName = "test1"

        whenever(calculateService.addUser(actual)).thenReturn(actual) /// mock method in service
        whenever(userRepository.findByFirstNameEquals(actual.firstName!!)).thenReturn(actual) // mock method in service
        val expected = calculateService.addUser(actual) // run result expected real

        Assertions.assertEquals(actual,expected)  // compare
    }


    @Test
    fun `should editUser test`(){
        val actual = mock<User>()

        actual.firstName = "test2"
        actual.lastName = "test2"
        actual.id = 1

       whenever(calculateService.editUser(actual, actual.id!!)).thenReturn(actual)
       whenever(userRepository.saveAndFlush(actual)).thenReturn(actual)
        val expected = calculateService.editUser(actual,actual.id!!)

        Assertions.assertEquals(actual,expected)

    }

    @Test
    fun `should deleteUser test`(){
//        val actual = mock<User>()
//        actual.id = 1
//
//        val expected = userRepository.deleteById(actual.id!!)
//        whenever(userRepository.deleteById(actual.id!!))
//
//        verify(userRepository, times(1)).deleteById(actual.id!!);

    }

}