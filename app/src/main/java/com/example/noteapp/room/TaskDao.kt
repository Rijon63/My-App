package com.example.noteapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.data.entity.Task

// Data Access Object (DAO) for Task entity
@Dao
interface TaskDao {

    // Retrieves all tasks from the database as LiveData
    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<Task>>

    // Inserts a task into the database
    @Insert
    suspend fun addTask(task: Task)

    // Updates a task in the database
    @Update
    suspend fun updateTask(task: Task)

    // Deletes a task from the database
    @Delete
    suspend fun deleteTask(task: Task)
}
