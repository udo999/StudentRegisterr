package com.example.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Studnet

class StudentRecyclerViewAdapter(
    private val clickListener:(Studnet) -> Unit) : RecyclerView.Adapter<StudentViewHolder>() {

    private val studentList = ArrayList<Studnet>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return StudentViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
    fun setList(students:List<Studnet>){
        studentList.clear()
        studentList.addAll(students)
    }

}

class StudentViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
    fun bind(studnet: Studnet, clickListener:(Studnet) -> Unit){
        val nameTextView = view.findViewById<TextView>(R.id.tvName)
        val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
        nameTextView.text = studnet.name
        emailTextView.text = studnet.email
        view.setOnClickListener{
            clickListener(studnet)
        }
    }
}