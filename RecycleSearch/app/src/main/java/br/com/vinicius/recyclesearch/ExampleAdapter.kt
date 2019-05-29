package br.com.vinicius.recyclesearch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

internal class ExampleAdapter(var lista: List<String>?) : RecyclerView.Adapter<ExampleAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        val exampleAdapter = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.adapter_example, viewGroup, false)
        return Holder(exampleAdapter)
    }

    override fun onBindViewHolder(holder: Holder, i: Int) {
        holder.textView.text = lista!![i]
    }

    override fun getItemCount(): Int {
        return if (lista == null) 0 else lista!!.size
    }

    fun filterList(filteredList: ArrayList<String>) {
        lista = filteredList
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView: TextView

        init {
            textView = itemView.findViewById(R.id.textView)
        }

    }
}
