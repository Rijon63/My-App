package com.example.noteapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.entity.Task
import com.example.noteapp.databinding.CardTaskBinding
import com.example.noteapp.ui.fragments.HomeFragmentDirections
import com.example.noteapp.ui.viewmodel.TaskViewModel
import com.example.noteapp.utils.Calculations
import com.google.android.material.snackbar.Snackbar

// Adapter class for the RecyclerView in the task list
class TaskAdapter(var viewModel: TaskViewModel) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder class for the RecyclerView items
    inner class TaskViewHolder(val itemBinding: CardTaskBinding) : RecyclerView.ViewHolder(itemBinding.root)

    // DiffUtil callback for calculating differences in the list
    private val differCallback = object : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            // Checks if the task items are the same based on their IDs and essential fields
            return oldItem.task_id == newItem.task_id &&
                    oldItem.task_title == newItem.task_title &&
                    oldItem.task_description == newItem.task_description &&
                    oldItem.task_deadline == newItem.task_deadline
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            // Checks if the contents of the task items are the same
            return oldItem == newItem
        }
    }

    // AsyncListDiffer to compute and dispatch item changes in the RecyclerView
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // Inflates the layout for each RecyclerView item
        val binding = CardTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // Returns the current number of items in the list
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        // Binds data to the ViewHolder
        val currentTask = differ.currentList[position]

        // Calculates the remaining time based on task deadline
        val timeRemaining = Calculations.calculateRemainingTime(currentTask.task_deadline)

        // Sets task details to the corresponding views in the layout
        holder.itemBinding.noteTitle.text = currentTask.task_title
        holder.itemBinding.noteDesc.text = currentTask.task_description
        holder.itemBinding.deadline.text = currentTask.task_deadline
        holder.itemBinding.creationTime.text = "($timeRemaining)"

        // Sets click listener for delete button with a Snackbar confirmation
        holder.itemBinding.ivDELETE.setOnClickListener {
            Snackbar.make(it, "DELETE ${currentTask.task_title}?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.deleteTask(currentTask.task_id)
                }
                .show()
        }

        // Sets click listener for the whole card view to navigate to edit task screen
        holder.itemBinding.cardView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditTaskFragment(currentTask)
            Navigation.findNavController(it).navigate(direction)
        }
    }
}
