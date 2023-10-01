package com.example.cse565_proj3

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class InterestsArrayAdapter(context: Context, private val items: List<ListItem>) :
    ArrayAdapter<ListItem>(context, R.layout.interest_list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.interest_list_item, parent, false)

        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
        val textView = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        val item = items[position]
        checkBox.isChecked = item.isChecked
        textView.text = item.text

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
        }

        imageView.setImageResource(item.image)

        return view
    }
}
