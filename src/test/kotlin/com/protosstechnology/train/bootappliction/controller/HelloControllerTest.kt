package com.protosstechnology.train.bootappliction.controller

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.protosstechnology.train.bootappliction.service.CalculateService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.contracts.contract


@ExtendWith(SpringExtension::class)
@WebMvcTest(HelloController::class)
class HelloControllerTest(@Autowired private val mockMvc: MockMvc) {
//    (@Autowired private val mockMvc: MockMvc)  -> send to constructor
/// MockMvc visual demo test api

   @MockBean lateinit var calculateService: CalculateService // define service for use to test

   @Test
   fun `should return hello world `(){
      mockMvc.perform(
         MockMvcRequestBuilders.get("/hello")
      ).andExpect(MockMvcResultMatchers.status().isOk)
   }

   @Test
   fun `should return calculate service `(){
      val result = 3
      whenever(calculateService.calculateNumber(any(),any())).thenReturn(result)  /// จำลอง ให้ ผลลัพธ์ ออกมาตามที่เรากำหนด

     mockMvc.perform(
         MockMvcRequestBuilders.get("/calculate?a=1&b=2")
      ).andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().string("3"))  /// test เพื่อให้ผลลัพธ์ ออกมาตามที่เรา จำลองไว้
   }

  }