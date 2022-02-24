package com.wasimsirschaudharyco.adapter.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wasimsirschaudharyco.R
import com.wasimsirschaudharyco.fragment.AssignmentListener
import com.wasimsirschaudharyco.model.assignment.AssignmentModel
import kotlinx.android.synthetic.main.row_assignment.view.*

class AssignmentAdapter(
    val context: Context,
    private val completedLive: List<AssignmentModel>,
    val listener: AssignmentListener
) : RecyclerView.Adapter<AssignmentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.row_assignment, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val studyItem = completedLive[position]
        holder.itemView.assign_name.text = studyItem.title
        holder.itemView.expand_text_view.text = "Description : "+ studyItem.description
        holder.itemView.assign_date.text = studyItem.date
        holder.itemView.assign_teacher.text = "Teacher : "+ studyItem.teacherName


        holder.itemView.ply_adapter_img.setOnClickListener {
            studyItem.attachment?.let { it1 -> listener.onAssignmentClicked(it1) }
        }

    }

    override fun getItemCount(): Int {
        return completedLive.size
    }
}