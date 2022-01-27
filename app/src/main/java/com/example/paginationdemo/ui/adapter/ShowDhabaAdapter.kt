package com.example.paginationdemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationdemo.databinding.DhabalistingInflaterBinding
import com.example.paginationdemo.model.Dhaba
import com.example.paginationdemo.model.DhabaLocationResponse

class ShowDhabaAdapter(val context:Context, val list1: List<DhabaLocationResponse>): RecyclerView.Adapter<ShowDhabaAdapter.ViewHolderClass>() {


    class ViewHolderClass(val binding: DhabalistingInflaterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var list1 = mutableListOf<String>()
        fun dhabadetail(data: Dhaba, context: Context) {
            binding.dhabaDetails = data

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

        val binding =
            DhabalistingInflaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)


    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        holder.dhabadetail(list1.get(position).dhaba, context)
    }


    override fun getItemCount(): Int {
        return list1.size
    }
}
