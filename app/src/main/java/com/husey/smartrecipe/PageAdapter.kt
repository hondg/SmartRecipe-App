package com.husey.smartrecipe
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
class PageAdapter(fragmentManager:FragmentManager,lifecycle:
Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->AllRecipes()
            1->AvailableRecipes()
            2->MyIngredients()
            else->AllRecipes()
        }
    }
}
