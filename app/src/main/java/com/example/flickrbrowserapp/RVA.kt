package com.example.flickrbrowserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVA(val activity: MainActivity, private val photos: ArrayList<Image>): RecyclerView.Adapter<RVA.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    // for binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.itemView.apply {
            var tvImageText = findViewById<TextView>(R.id.tvImageText)
            tvImageText.text = photo.title

            var ivThumbnail =findViewById<ImageView>(R.id.ivThumbnail)
            var llItemRow =findViewById<LinearLayout>(R.id.llItemRow)
            Glide.with(activity).load(photo.link).into(ivThumbnail)
            llItemRow.setOnClickListener { activity.openImg(photo.link) }
        }
    }
    override fun getItemCount() = photos.size
}