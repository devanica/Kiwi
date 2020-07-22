package kiwi.app.util

import androidx.core.content.ContextCompat
import kiwi.app.R
import kiwi.app.model.Base
import kiwi.app.model.Ingredient

object Util {
    var ingredients = ArrayList<Ingredient>()

    fun loadIngredinets() {
        ingredients.add(0, Ingredient(0, R.drawable.apple, false))
        ingredients.add(1, Ingredient(1, R.drawable.apricot, false))
        ingredients.add(2, Ingredient(2, R.drawable.banana, false))
        ingredients.add(3, Ingredient(3, R.drawable.blackberry, false))
        ingredients.add(4, Ingredient(4, R.drawable.blueberry, false))
        ingredients.add(5, Ingredient(5, R.drawable.cantaloupe, false))
        ingredients.add(6, Ingredient(6, R.drawable.carrot, false))
        ingredients.add(7, Ingredient(7, R.drawable.cherry, false))
        ingredients.add(8, Ingredient(8, R.drawable.chocolate, false))
        ingredients.add(9, Ingredient(9, R.drawable.coffee, false))
        ingredients.add(10, Ingredient(10, R.drawable.grape, false))
        ingredients.add(11, Ingredient(11, R.drawable.grapefruit, false))
        ingredients.add(12, Ingredient(12, R.drawable.herbs, false))
        ingredients.add(13, Ingredient(13, R.drawable.kiwi, false))
        ingredients.add(14, Ingredient(14, R.drawable.lemon, false))
        ingredients.add(15, Ingredient(15, R.drawable.lime, false))
        ingredients.add(16, Ingredient(16, R.drawable.mango, false))
        ingredients.add(17, Ingredient(17, R.drawable.melon, false))
        ingredients.add(18, Ingredient(18, R.drawable.orange, false))
        ingredients.add(19, Ingredient(19, R.drawable.peach, false))
        ingredients.add(20, Ingredient(20, R.drawable.pineapple, false))
        ingredients.add(21, Ingredient(21, R.drawable.raspberry, false))
        ingredients.add(22, Ingredient(22, R.drawable.strawberry, false))
        ingredients.add(23, Ingredient(23, R.drawable.tangerine, false))
        ingredients.add(24, Ingredient(24, R.drawable.watermelon, false))
    }

    fun updateIngredients(position: Int, isSelected: Boolean){
        ingredients[position].isSelected = isSelected
    }

    var bases = ArrayList<Base>()

    fun loadBases() {
        bases.add(0, Base(0, R.string.milk.toString(), false))
        bases.add(1, Base(1, R.string.coconut_water.toString(), false))
        bases.add(2, Base(2, R.string.coffee.toString(), false))
        bases.add(3, Base(3, R.string.water.toString(), false))
        bases.add(4, Base(4, R.string.tea.toString(), false))
        bases.add(5, Base(5, R.string.almond_milk.toString(), false))
        bases.add(6, Base(6, R.string.juice.toString(), false))
        bases.add(7, Base(7, R.string.soy_milk.toString(), false))
        bases.add(8, Base(8, R.string.vanilla_yogurt.toString(), false))
        bases.add(9, Base(9, R.string.chocolate_milk.toString(), false))
    }

    fun updateBases(position: Int, isSelected: Boolean){
        bases[position].isSelected = isSelected
    }

}