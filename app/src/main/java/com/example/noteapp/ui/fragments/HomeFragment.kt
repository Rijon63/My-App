package com.example.noteapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteapp.R
import com.example.noteapp.data.entity.Task
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.ui.adapter.TaskAdapter
import com.example.noteapp.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var taskViewModel : TaskViewModel
    private lateinit var taskAdapter : TaskAdapter

    // Inflates the layout for the fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    // Sets up ViewModel using viewModels delegate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : TaskViewModel by viewModels()
        taskViewModel = tempViewModel
    }

    // Initializes UI components and sets up RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sets up RecyclerView to display tasks
        setupHomeRecyclerView()

        // Navigates to AddTaskFragment when FAB is clicked
        binding.fabAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
    }

    // Sets up RecyclerView with StaggeredGridLayoutManager and observes task data changes
    private fun setupHomeRecyclerView(){
        taskAdapter = TaskAdapter(taskViewModel)
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = taskAdapter
        }

        // Observes changes in task data and updates RecyclerView
        activity?.let {
            taskViewModel.getAllTasks().observe(viewLifecycleOwner){ tasks ->
                taskAdapter.differ.submitList(tasks)
                updateUI(tasks)
            }
        }
    }

    // Updates UI based on whether tasks are available or not
    private fun updateUI(tasks: List<Task>) {
        if (tasks.isNotEmpty()) {
            binding.noAddedtaskText.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        } else {
            binding.noAddedtaskText.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        }
    }
}
