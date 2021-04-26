package com.example.recyclevievinrecycleviewtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclevievinrecycleviewtest.R
import com.example.recyclevievinrecycleviewtest.models.ParentModel

class ParentAdapter(private val parents : List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>(){

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.title
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            adapter = ChildAdapter(parent.children)
            setRecycledViewPool(viewPool)
        }
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.findViewById(R.id.rv_child)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}