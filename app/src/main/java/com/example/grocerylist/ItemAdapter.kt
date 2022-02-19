package com.example.grocerylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.specific_grocery_item.view.*

class ItemAdapter (
    private val items: MutableList<Item>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.specific_grocery_item, parent, false)
        )
    }
    
    fun addItem(item: Item) {
        items.add(item)
        notifyItemInserted(items.size-1)
    }
    
    fun deleteDone(){
        items.removeAll { item ->
            item.isChecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val curItem = items[position]
        holder.itemView.apply{
            tvItemTitle.text = curItem.title
            cbDone.isChecked = curItem.isChecked
            cbDone.setOnCheckedChangeListener { _, _ ->
                curItem.isChecked = !curItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}