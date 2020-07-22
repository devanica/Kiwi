package kiwi.app.util.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kiwi.app.R
import kiwi.app.model.Smoothie
import kotlinx.android.synthetic.main.smoothie_list_member.view.*

class SmoothiesAdapter(val smoothies : ArrayList<Smoothie>, val listener: (Smoothie) -> Unit):
    RecyclerView.Adapter<SmoothiesAdapter.SmoothieHolder>() {

    fun updateSmoothies(newSmoothies: List<Smoothie>) {
        smoothies.clear()
        smoothies.addAll(newSmoothies)
        notifyDataSetChanged()
    }

    private fun selectSmoothies(position: Int): Smoothie {
        val selectedSmoothie = smoothies.find { it.id == position }
        return selectedSmoothie!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmoothieHolder {
        return SmoothieHolder(LayoutInflater.from(parent.context).inflate(R.layout.smoothie_list_member, parent, false))
    }

    override fun getItemCount(): Int {
        return smoothies.size
    }

    override fun onBindViewHolder(holder: SmoothieHolder, position: Int) {
        holder.bind(smoothies[position])
        holder.smoothieFrame.setOnClickListener {
            listener(selectSmoothies(position))
        }
    }

    class SmoothieHolder(view: View): RecyclerView.ViewHolder(view) {
        val smoothieFrame: CardView = view.cv_smoothie
        val smoothieTitle: TextView = view.tv_smoothieTitle
        val smoothieIngredients: TextView = view.tv_smoothieFruit
        val smoothieBase: TextView = view.tv_smoothieBase
        val smoothieImage: ImageView = view.iv_smoothie

        fun bind(mSmoothie: Smoothie) {
            smoothieTitle.text = mSmoothie.smoothie
            smoothieIngredients.text = mSmoothie.ingredients
            smoothieBase.text = mSmoothie.base

            // TODO: LOAD smoothies image from a website you have downloaded it,
            //  where there is no image, just add the existing ones
            smoothieImage.loadImage(R.drawable.soft_peach)
        }

        // TODO: This is the solution for a context issue, ImageView is granting it's context
        fun ImageView.loadImage(uri: Int?) {
            Glide.with(this.context)
                .asBitmap().load(uri)
                .into(this)
        }
    }
}