package com.recipeexplorer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recipeexplorer.ui.list.ListFragment
import com.recipeexplorer.R
import com.recipeexplorer.ext.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(ListFragment(), R.id.content)
    }
}


