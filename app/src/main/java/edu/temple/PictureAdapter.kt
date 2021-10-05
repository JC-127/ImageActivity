package edu.temple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView
import android.widget.ImageView


class ImageAdapter (private val GhostRiderArray: Array<Picture>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>()
{
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.itemHolder)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.item_holder, parent, false)

        return ViewHolder(contactView,mListener)
    }


    override fun onBindViewHolder(viewHolder: ImageAdapter.ViewHolder, position: Int) {

        val GhostRider: Picture = GhostRiderArray[position]

        val imageView = viewHolder.imageView
        imageView.setImageResource(GhostRider.heading)
    }


    override fun getItemCount(): Int {
        return GhostRiderArray.size
    }

}