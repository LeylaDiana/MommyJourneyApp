package com.example.mommyjourneyapp

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mommyjourneyapp.MyAdapter1.*

class MyAdapter2 (private val userlist : ArrayList<Users>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder2>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.useritem3,
            parent,false)
        return MyViewHolder2(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {

        val currentitem = userlist[position]

        holder.fullName.text = currentitem.FullName
        holder.date.text = currentitem.Birthdate
        holder.iCNo.text = currentitem.ICNO

    }

    override fun getItemCount(): Int {

        return userlist.size
    }


    class MyViewHolder2(itemView : View) : RecyclerView.ViewHolder(itemView){

        val fullName : TextView = itemView.findViewById(R.id.tvfullname)
        val date : TextView = itemView.findViewById(R.id.tvbirthdate)
        val iCNo : TextView = itemView.findViewById(R.id.tvICnombor)

    }

}