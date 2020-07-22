package kiwi.app.util.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kiwi.app.R
import kiwi.app.model.Ingredient
import kotlinx.android.synthetic.main.ingredient_list_member.view.*

class IngredientsAdapter(val ingredients : ArrayList<Ingredient>, val listener: (Ingredient) -> Unit):
                        RecyclerView.Adapter<IngredientsAdapter.IngredientHolder>() {

    private fun selectIngredients(position: Int): Ingredient{
        val selectedIngredient = ingredients.find { it.position == position }
        selectedIngredient!!.isSelected = !selectedIngredient.isSelected
        notifyItemChanged(selectedIngredient.position)
        return selectedIngredient
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientHolder {
        return IngredientHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingredient_list_member, parent, false))
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: IngredientHolder, position: Int) {
        holder.bind(ingredients[position])
        holder.ingredientFrame.setOnClickListener {
            listener(selectIngredients(position))
        }
    }

    class IngredientHolder(view: View): RecyclerView.ViewHolder(view) {
        val ingredientFrame: CardView = view.cv_ingredient
        val ingredientImage: ImageView = view.iv_ingredient
        val ingredientMask: ImageView = view.iv_ingredientMask

        fun bind(mIngredient: Ingredient) {
            ingredientImage.loadImage(mIngredient.smoothie)
            if (mIngredient.isSelected){
                ingredientMask.visibility = INVISIBLE
            }else{
                ingredientMask.visibility = VISIBLE
            }
        }

        // TODO: This is the solution for a context issue, ImageView is granting it's context
        fun ImageView.loadImage(uri: Int?) {
            Glide.with(this.context)
                .asBitmap().load(uri)
                .into(this)
        }
    }
}

