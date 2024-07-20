package com.example.noteapp.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0019"}, d2 = {"Lcom/example/noteapp/ui/viewmodel/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/noteapp/data/repository/TaskRepository;", "(Lcom/example/noteapp/data/repository/TaskRepository;)V", "getRepository", "()Lcom/example/noteapp/data/repository/TaskRepository;", "setRepository", "addTask", "", "task_title", "", "task_desc", "task_deadLine", "task_creation_time", "Lkotlin/Pair;", "deleteTask", "task_id", "", "getAllTasks", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/noteapp/data/entity/Task;", "updateTask", "task", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private com.example.noteapp.data.repository.TaskRepository repository;
    
    @javax.inject.Inject
    public TaskViewModel(@org.jetbrains.annotations.NotNull
    com.example.noteapp.data.repository.TaskRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.noteapp.data.repository.TaskRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull
    com.example.noteapp.data.repository.TaskRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.noteapp.data.entity.Task>> getAllTasks() {
        return null;
    }
    
    public final void addTask(@org.jetbrains.annotations.NotNull
    java.lang.String task_title, @org.jetbrains.annotations.NotNull
    java.lang.String task_desc, @org.jetbrains.annotations.NotNull
    java.lang.String task_deadLine, @org.jetbrains.annotations.NotNull
    kotlin.Pair<java.lang.String, java.lang.String> task_creation_time) {
    }
    
    public final void deleteTask(int task_id) {
    }
    
    public final void updateTask(@org.jetbrains.annotations.NotNull
    com.example.noteapp.data.entity.Task task) {
    }
}