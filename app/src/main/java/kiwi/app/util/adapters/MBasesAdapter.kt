package kiwi.app.util.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kiwi.app.R
import kiwi.app.model.Base
import kotlinx.android.synthetic.main.base_list_member.view.*
import kotlin.collections.ArrayList

class MBasesAdapter(val bases: ArrayList<Base>, val listener: (Base) -> Unit):
                    RecyclerView.Adapter<MBasesAdapter.BaseHolder>() {

    private fun selectBase(position: Int): Base{
        val selectedBase = bases.find { it.position == position }
        selectedBase!!.isSelected = !selectedBase.isSelected
        notifyItemChanged(selectedBase.position)
        return selectedBase
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return BaseHolder(LayoutInflater.from(parent.context).inflate(R.layout.base_list_member, parent, false))
    }

    override fun getItemCount(): Int {
        return bases.size
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.bind(bases[position])
        holder.base.setOnClickListener {
            listener(selectBase(position))
        }
    }

    class BaseHolder(view: View): RecyclerView.ViewHolder(view) {
        val base: CardView = view.cv_base
        val baseTitle: TextView = view.tv_base

        fun bind(mBase: Base) {
            baseTitle.text = mBase.base
            if (mBase.isSelected) {
                base.setColor(R.color.peach_pink)
            } else {
                base.setColor(R.color.colorPrimaryDark)
            }
        }

        // TODO: This is the solution for a context issue, ImageView is granting it's context
        fun CardView.setColor(color: Int) {
            setBackgroundColor(ContextCompat.getColor(this.context, color))
        }
    }
}
