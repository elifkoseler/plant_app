package com.elif.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elif.domain.model.Article
import com.elif.presentation.R

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val items = mutableListOf<Article>()

    @SuppressLint("NotifyDataSetChanged")
    fun setArticles(newList: List<Article>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.articleImage)
        val title = itemView.findViewById<TextView>(R.id.articleTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_article_card_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = items[position]
        holder.title.text = article.title
        Glide.with(holder.itemView.context)
            .load(article.imageUri)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.uri))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}
