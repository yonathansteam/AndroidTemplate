package com.example.yonyo.templateproject.view

class CovariancePlayground {



}

//Link : https://proandroiddev.com/understanding-generics-and-variance-in-kotlin-714c14564c47

abstract class Animal(val size: Int)
class Dog(val cuteness : Int) : Animal(100)
class Spider(val terrorFactor : Int) : Animal(1)


//Covariance
val dogList: List<Dog> = listOf()
val animalList: List<Animal> = dogList

//val spiderList: List<Spider> = animalList // Compiler error, cannot assign List<Animal> to List<Spider>

//Invariance
//Code in java
//var dogList: List<Dog> = ArrayList()
//var animalList: List<Animal> = dogList // Compiler error

//ContraVariance
interface Compare<in T> {
    fun compare(first: T, second: T): Int
}

val dogCompare: Compare<Dog> = object : Compare<Dog> {
    override fun compare(first: Dog, second: Dog): Int {
        return first.cuteness - second.cuteness
    }
}

//val animalCompare: Compare<Animal> = dogCompare

val spider: Compare<Spider> = object : Compare<Animal>{
    override fun compare(first: Animal, second: Animal): Int {
        return first.size - second.size
    }
}

val animalCompare: Compare<Animal> = object: Compare<Animal> {
    override fun compare(first: Animal, second: Animal): Int {
        return first.size - second.size
    }
}
val spiderCompare: Compare<Spider> = animalCompare // Works nicely!

