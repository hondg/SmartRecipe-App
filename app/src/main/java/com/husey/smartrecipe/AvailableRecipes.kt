package com.husey.smartrecipe
import CSVReader
import RecipeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.husey.smartrecipe.databinding.FragmentAvailableRecipesBinding


class AvailableRecipes : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_available_recipes,
            container, false)
    }
}
