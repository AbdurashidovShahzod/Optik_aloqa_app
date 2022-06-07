package uz.unzosoft.optikaloqaapp.app.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class SuperListAdapter<T>(
    private val viewId: Int,
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, SuperListAdapter<T>.MyHolder>(diffUtil) {

    constructor(
        viewId: Int,
        areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
        areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
    ) : this(viewId, object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return areContentsTheSame(oldItem, newItem)
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyHolder(inflater.inflate(viewId, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindHolder(position)
    }

    inner class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindHolder(position: Int) {
            bind(getItem(position), view, position)
        }
    }

    abstract fun bind(t: T, view: View, adapterPosition: Int)
}