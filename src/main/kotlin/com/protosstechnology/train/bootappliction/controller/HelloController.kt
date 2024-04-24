package com.protosstechnology.train.bootappliction.controller

import com.protosstechnology.train.bootappliction.entity.User
import com.protosstechnology.train.bootappliction.service.CalculateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*


// presentation Controller
@RestController // tell compiler this file is  rest api
class HelloController {

    @Autowired
    private lateinit var calculateService: CalculateService

    @Autowired
    lateinit var CalculateService: CalculateService

    @GetMapping("/hello")
    fun helloWorld(): ResponseEntity<String> {
        return ResponseEntity.status(200).body("Hello World")
    }

    @GetMapping("/calculate")
    fun calculate(
       @RequestParam("a") a:Int,
       @RequestParam("b") b:Int
    ): ResponseEntity<Int> {
        return ResponseEntity.status(200).body(calculateService.calculateNumber(a,b))
    }

    @PostMapping("/userData")
    fun userData(
        @RequestBody user:User
    ): ResponseEntity<User> {
        return ResponseEntity.status(200).body(CalculateService.addUser(user))
    }


    @PutMapping("/userData")
    fun updateUserData(
        @RequestParam("id") id:Long,
        @RequestBody user:User
    ):ResponseEntity<User>{
        return ResponseEntity.status(200).body(CalculateService.editUser(user,id))
    }


    @DeleteMapping("/userData")
    fun deleteUserData(
        @RequestParam("id") id:Long
    ): ResponseEntity<String> {
        CalculateService.deleteUser(id)
        return ResponseEntity.status(200).body("200")
    }


}