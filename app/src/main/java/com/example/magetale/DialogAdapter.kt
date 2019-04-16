package com.example.magetale

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DialogAdapter : RecyclerView.Adapter<DialogAdapter.DialogViewHolder>() {

    var list: List<GameObject>? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): DialogViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_item, parent, false)
        return DialogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        if (list!![position].name == "Hero"){
            holder.text.gravity = Gravity.START
        }else{
            holder.text.gravity = Gravity.END
        }
        holder.text.setTextColor(list!![position].color)
    }

    fun swipeList(list: List<GameObject>) {
        if (this.list != null) {
            this.list = null
        }
        this.list = list
    }

    class DialogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.dialogTV)
    }
}