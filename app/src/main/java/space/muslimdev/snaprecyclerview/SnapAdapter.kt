package space.muslimdev.snaprecyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView


class SnapAdapter : RecyclerView.Adapter<SnapViewHolder>() {

    private val listAdapter by lazy { initList() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnapViewHolder =
        SnapViewHolder.create(parent)

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: SnapViewHolder, position: Int) {
        holder.bind(listAdapter[position])
    }

    private fun initList(): ArrayList<String> {
        val list = arrayListOf<String>()
        for (x in 1..10) {
            list.add("Item $x")
        }
        return list
    }
}