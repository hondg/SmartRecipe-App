import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.husey.smartrecipe.R
import com.husey.smartrecipe.Recipe
import com.husey.smartrecipe.databinding.RecipeRecyclerRowBinding

class RecipeAdapter(private val recipes: List<Recipe>,private val clickListener: (Recipe) -> Unit) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: RecipeRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = RecipeRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.binding.recipeName.text = recipe.name
        holder.binding.recipeCalories.text = "${recipe.calories} kcal"
        Glide.with(holder.itemView.context).load(recipe.image).into(holder.binding.imageView)
        holder.itemView.setOnClickListener { clickListener(recipe) }

    }

    override fun getItemCount() = recipes.size
}
