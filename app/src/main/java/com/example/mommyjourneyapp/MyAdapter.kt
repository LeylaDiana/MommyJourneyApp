package com.example.mommyjourneyapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList : ArrayList<Users>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.bplevel.text = currentitem.BPLevel
        holder.height.text = currentitem.Height
        holder.urinecolor.text = currentitem.UrineColor
        holder.weight.text = currentitem.Weight

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val bplevel : TextView = itemView.findViewById(R.id.tvbplevel)
        val height : TextView = itemView.findViewById(R.id.tvheight)
        val urinecolor : TextView = itemView.findViewById(R.id.tvurinecolor)
        val weight : TextView = itemView.findViewById(R.id.tvweight)

    }

}