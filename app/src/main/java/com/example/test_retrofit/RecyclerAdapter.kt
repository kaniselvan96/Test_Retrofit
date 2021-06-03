package com.example.test_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class RecyclerAdapter(val context: Context, val dataList: List<DataModelItem>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemId: TextView

        init {
            itemTitle = itemView.item_title
            itemId = itemView.item_id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = dataList[position].title
        holder.itemId.text = dataList[position].id.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



}