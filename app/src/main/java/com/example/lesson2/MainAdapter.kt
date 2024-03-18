package com.example.lesson2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CellAdapter(
    private val cells: List<Int>
) : RecyclerView.Adapter<CellAdapter.CellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_fragment, parent, false)
        return CellViewHolder(view)
    }


    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.bind(cells[position])
    }

    override fun getItemCount(): Int = cells.size

    class CellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNum: TextView =
            itemView.findViewById(R.id.view_fragment__tv_number)
        private val cardView: CardView =
            itemView.findViewById(R.id.view_fragment__card_view)

        init {
            itemView.setOnClickListener {
                val intent = Intent(it.context, SecondActivity::class.java)
                intent.putExtra(MainActivity.NUMBER, tvNum.text)
                it.context.startActivity(intent)
            }
        }

        fun bind(cell: Int) {
            tvNum.text = cell.toString()
            cardView.setBackgroundResource(
                if (cell % 2 == 0)
                    R.color.imperial
                else
                    R.color.cobalt
            )
        }
    }
}