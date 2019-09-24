package com.recipeexplorer.doman

import com.freenow.domain.mapper.BaseMapper
import com.recipeexplorer.data.entity.RecipeEntity
import com.recipeexplorer.vo.Recipe
import javax.inject.Inject

class RecipeMapper @Inject constructor() : BaseMapper<RecipeEntity,Recipe>() {
    override fun mapFrom(from: RecipeEntity): Recipe {
        return Recipe(from.id,from.title,from.imageUrl)
    }
}