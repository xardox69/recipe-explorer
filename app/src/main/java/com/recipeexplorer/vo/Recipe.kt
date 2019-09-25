package com.recipeexplorer.vo

class Recipe (val id:String, val title:String, private val imageUrl:String) {

     val fullUrl:String
    get() = ("http:").plus(imageUrl)

}