package com.example.recyclevievinrecycleviewtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclevievinrecycleviewtest.R
import com.example.recyclevievinrecycleviewtest.models.ChildModel

class ChildAdapter(private val children : List<ChildModel>)
    : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.child_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        holder.imageView.setImageResource(child.image)
        holder.textView.text = child.title
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.findViewById(R.id.child_textView)
        val imageView: ImageView = itemView.findViewById(R.id.child_imageView)

    }
}