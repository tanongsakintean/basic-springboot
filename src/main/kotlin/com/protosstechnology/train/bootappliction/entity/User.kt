package com.protosstechnology.train.bootappliction.entity

import jakarta.persistence.*

// create data class for bind table database to class User
@Entity // tell compiler this file is Entity class
@Table(name="TBUser")  /// name of table database
data class User(
    @Id /// primary key of an entity class
    @GeneratedValue(strategy = GenerationType.IDENTITY) /// autoincrement
    @Column(name = "id") /// column id is field id in table
    var id:Long? = null, /// define id type long

    @Column(name = "firstName")
    var firstName:String? = null,

    @Column(name = "lastName")
    var lastName:String? = null,
)
