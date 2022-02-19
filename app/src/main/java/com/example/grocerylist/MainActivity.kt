package com.example.grocerylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemAdapter = ItemAdapter(mutableListOf())

        rvGroceryListItems.adapter = itemAdapter
        rvGroceryListItems.layoutManager = LinearLayoutManager(this)

        btnAddItem.setOnClickListener {
            val itemTitle = etTitle.text.toString()
            if(itemTitle.isNotEmpty()){
                val item = Item(itemTitle)
                itemAdapter.addItem(item)
                etTitle.text.clear()
            }
        }
        btnDeleteCheckedItems.setOnClickListener {
            itemAdapter.deleteDone()
        }
    }
}