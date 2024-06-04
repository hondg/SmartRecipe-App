package com.husey.smartrecipe
import CSVReader
import RecipeAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.husey.smartrecipe.databinding.FragmentAllRecipesBinding


class AllRecipes : Fragment() {
    private lateinit var binding: FragmentAllRecipesBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var csvReader: CSVReader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllRecipesBinding.inflate(inflater, container,
            false)
        csvReader = CSVReader(requireContext())
        val recipes = csvReader.readCSVFile("food_dataset.csv")


        recipeAdapter = RecipeAdapter(recipes) { recipe ->
            val intent = Intent(activity, RecipeDetailActivity::class.java).apply {
                putExtra("recipe", recipe)
            }
            startActivity(intent)
        }
        binding.recipeList.layoutManager = LinearLayoutManager(context)
        binding.recipeList.adapter = recipeAdapter
        return binding.root
    }
}
