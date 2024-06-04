import java.io.BufferedReader
import java.io.InputStreamReader
import android.content.Context
import com.husey.smartrecipe.Recipe

class CSVReader(private val context: Context) {
    fun readCSVFile(fileName: String): List<Recipe> {
        val recipes = mutableListOf<Recipe>()
        val inputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.useLines { lines ->
            lines.drop(1).forEach { line ->
                val tokens = line.split(",")
                if (tokens.size == 6) {
                    val recipe = Recipe(
                        id = tokens[0].toInt(),
                        name = tokens[1],
                        instructions = tokens[2],
                        image = tokens[3],
                        ingredientsParts = tokens[4],
                        calories = tokens[5]
                    )
                    recipes.add(recipe)
                }
            }
        }
        return recipes
    }
}
