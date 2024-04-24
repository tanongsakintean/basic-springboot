package com.protosstechnology.train.bootappliction.repository

import com.protosstechnology.train.bootappliction.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

// create interface to bind database and class by JPA
interface UserRepository : JpaRepository<User, Long> { // parameter Long is ID of table
    fun findByFirstNameEquals(firstName: String): User

    @Query("FROM User u WHERE u.firstName = :firstName")
    fun selectByFirstNameEquals(@Param("firstName") firstName: String): User
}