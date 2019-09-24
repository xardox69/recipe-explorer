package com.recipeexplorer.ext

import com.recipeexplorer.ui.MainActivity
import com.recipeexplorer.ui.list.ListFragment

fun MainActivity.addFragment(listFragment: ListFragment, content: Int) {
    val transaction = supportFragmentManager.beginTransaction()

    transaction.replace(content, listFragment)
    transaction.commit()

}