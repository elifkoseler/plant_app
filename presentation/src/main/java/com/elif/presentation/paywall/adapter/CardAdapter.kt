package com.elif.presentation.paywall.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elif.presentation.R
import com.elif.presentation.paywall.model.CardItem

class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var items: List<CardItem> = emptyList()

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cardImage)
        val title: TextView = itemView.findViewById(R.id.cardTitle)
        val description: TextView = itemView.findViewById(R.id.cardDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.paywall_card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.image.setImageResource(item.imageResId)
        holder.title.text = context.getString(item.title)
        holder.description.text = context.getString(item.description)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<CardItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
