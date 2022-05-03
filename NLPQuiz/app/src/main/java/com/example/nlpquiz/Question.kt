package com.example.nlpquiz

// data class, for creating a question
data class Question (
    val id : Int,
    val question : String,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val correctAnswer : Int
    )
