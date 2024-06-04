// RecipeDetailActivity.kt
package com.husey.smartrecipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.husey.smartrecipe.databinding.RecipeDetailsBinding

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: RecipeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecipeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getParcelableExtra<Recipe>("recipe")

        recipe?.let {
            binding.recipeDetailsName.text = it.name
            binding.recipeDetailsInstructions.text = it.instructions.replace("; ", "\n")
            binding.recipeDetailsIngredients.text = it.ingredientsParts.replace("; ", "\n")
            Glide.with(this).load(it.image).into(binding.recipeDetailsImage)
        }
    }
}
