package com.example.drawermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawermenu.Items.Items.filteredListOfItems
import com.example.drawermenu.Items.Items.listOfItems
import com.example.drawermenu.adapters.DrawerAdapter
import com.example.drawermenu.adapters.HeaderAdapter
import com.example.drawermenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var drawerAdapter: DrawerAdapter
    lateinit var headerAdapter: HeaderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        listeners()
        filter()
    }

    private fun listeners() {
        drawerAdapter.itemClick = {
            Toast.makeText(this, "${it.title}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun init() {
        initRecycler()
        drawerAdapter.submitList(Items.listOfItems)
        headerAdapter.submitList(Items.listOfTypes)
    }

    private fun initRecycler() {
        drawerAdapter = DrawerAdapter()
        binding.recyclerView.apply {
            adapter = drawerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        headerAdapter = HeaderAdapter()
        binding.rvType.apply {
            adapter = headerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, true)
        }
    }

    private fun filter(){

        headerAdapter.itemClick = {

            drawerAdapter.showItemsByType(it.type.toString(), listOfItems)
            drawerAdapter.submitList(filteredListOfItems)

        }
    }
}