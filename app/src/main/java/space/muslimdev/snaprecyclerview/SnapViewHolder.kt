package space.muslimdev.snaprecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class SnapViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(title: String) {
        view.apply {
            tv_title.text = title
        }
    }

    companion object {
        fun create(parent: ViewGroup): SnapViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recyclerview, parent, false)
            return SnapViewHolder(view)
        }
    }
}