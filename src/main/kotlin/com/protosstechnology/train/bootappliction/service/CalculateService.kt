package com.protosstechnology.train.bootappliction.service

import com.protosstechnology.train.bootappliction.entity.User
import com.protosstechnology.train.bootappliction.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//    ฝาก ถอน เช็คยอด สร้าง account
@Service
class CalculateService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun calculateNumber(a:Int,b:Int):Int{
        return a + b
    }


    fun addUser(newUser:User): User {
        userRepository.save(newUser);
        return userRepository.selectByFirstNameEquals(newUser.firstName!!)
    }

   fun editUser(data:User,id:Long) : User {

       data.id = id
       userRepository.saveAndFlush(data)
       return data;
   }

    fun deleteUser(id:Long) {
       userRepository.deleteById(id)
    }
}