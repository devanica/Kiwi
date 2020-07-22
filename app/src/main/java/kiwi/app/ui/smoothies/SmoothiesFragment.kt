package kiwi.app.ui.smoothies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kiwi.app.R
import kiwi.app.model.Base
import kiwi.app.model.Smoothie
import kiwi.app.util.SP
import kiwi.app.util.Util
import kiwi.app.util.adapters.IngredientsAdapter
import kiwi.app.util.adapters.MBasesAdapter
import kiwi.app.util.adapters.SmoothiesAdapter
import kotlinx.android.synthetic.main.fragment_smoothies.*

class SmoothiesFragment : Fragment() {
    lateinit var ingredientsAdapter: IngredientsAdapter
    lateinit var smoothiesAdapter: SmoothiesAdapter
    lateinit var basesAdapter: MBasesAdapter
    var smoothies = arrayListOf<Smoothie>()

    var sp = SP.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: SmoothiesViewModel by viewModels()
        model.fetchSmoothies().observe(this, Observer{ mSmoothies ->
            smoothiesAdapter.updateSmoothies(mSmoothies)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smoothies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: THIS HAS SOME PROBLEMS WITH SAVEDINSTANCESTATE Util.loadIngredinets()

        rv_ingredients.setLayoutManager(LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))
        ingredientsAdapter = IngredientsAdapter(Util.ingredients) {
            Util.updateIngredients(it.position, it.isSelected)
            ingredientsAdapter.notifyItemChanged(it.position)
        }
        rv_ingredients.setAdapter(ingredientsAdapter)

        rv_bases.setLayoutManager(LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))
        basesAdapter = MBasesAdapter(Util.bases) {
            Util.updateBases(it.position, it.isSelected)
            basesAdapter.notifyItemChanged(it.position)
        }
        rv_bases.setAdapter(basesAdapter)

        rv_smoothies.setLayoutManager(LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))
        smoothiesAdapter = SmoothiesAdapter(smoothies) {
            navigateToSmoothie()
        }
        rv_smoothies.setAdapter(smoothiesAdapter)

        if (savedInstanceState != null){
            Util.ingredients = arrayListOf()
            Util.ingredients.addAll(savedInstanceState.getParcelableArrayList("ingredients")!!)
            ingredientsAdapter.notifyDataSetChanged()

            Util.bases = arrayListOf()
            Util.bases.addAll(savedInstanceState.getParcelableArrayList("bases")!!)
            basesAdapter.notifyDataSetChanged()
        }else{
            Util.loadIngredinets()
            Util.loadBases()
        }
    }

    private fun navigateToSmoothie() {
        findNavController().navigate(R.id.smoothieFragment)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("ingredients", Util.ingredients)
        outState.putParcelableArrayList("bases", Util.bases)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
