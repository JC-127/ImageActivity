package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

val GhostRiderArray: Array<Picture> = arrayOf(
    Picture("Ghost Rider 0",R.drawable.ghost_rider0),
    Picture("Ghost Rider 1",R.drawable.ghost_rider1),
    Picture("Ghost Rider 2",R.drawable.ghost_rider2),
    Picture("Ghost Rider 3",R.drawable.ghost_rider3),
    Picture("Ghost Rider 4",R.drawable.ghost_rider4),
    Picture("Ghost Rider 5",R.drawable.ghost_rider5),
    Picture("Ghost Rider 6",R.drawable.ghost_rider6),
    Picture("Ghost Rider 7",R.drawable.ghost_rider7),
    Picture("Ghost Rider 8",R.drawable.ghost_rider8),
    Picture("Ghost Rider 9",R.drawable.ghost_rider9)
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        var adapter = ImageAdapter(GhostRiderArray)

        recyclerView.adapter=adapter
        recyclerView.layoutManager= GridLayoutManager(this, 3)

        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                imageView.setImageResource(GhostRiderArray[position].heading)
                textView.setText(GhostRiderArray[position].titleImage)
            }

        })

    }
}