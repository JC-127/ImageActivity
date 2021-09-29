package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Picture>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.ghost_rider0,
            R.drawable.ghost_rider1,
            R.drawable.ghost_rider2,
            R.drawable.ghost_rider3,
            R.drawable.ghost_rider4,
            R.drawable.ghost_rider5,
            R.drawable.ghost_rider6,
            R.drawable.ghost_rider7,
            R.drawable.ghost_rider8,
            R.drawable.ghost_rider9
        )

        heading = arrayOf(

            "Ghost Rider 0",
            "Ghost Rider 1",
            "Ghost Rider 2",
            "Ghost Rider 3",
            "Ghost Rider 4",
            "Ghost Rider 5",
            "Ghost Rider 6",
            "Ghost Rider 7",
            "Ghost Rider 8",
            "Ghost Rider 9"
        )

        newRecyclerView = findViewById(R.id.Pictures)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Picture>()
        getUserdata()
    }

    private fun getUserdata() {

        for (i in imageId.indices) {

            val pics = Picture(imageId[i], heading[i])
            newArrayList.add(pics)

        }

        var adapter = PictureAdapter(newArrayList)
        newRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object: PictureAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "you clicked on $position", Toast.LENGTH_SHORT ).show()
            }
        })

    }

}
