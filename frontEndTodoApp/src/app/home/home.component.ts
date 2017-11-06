import { Component, OnInit } from '@angular/core';
import { TaskService, Task } from '../shared';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tasks: Task[] = [];
  isDeleted: boolean = false;
  newTask: any;
  addTaskForm: FormGroup;
  isUpdating: boolean = false;


  constructor(private taskService: TaskService) {
    this.taskService.getAllTasks()
      .then(data => this.tasks = data);
  }

  ngOnInit() {
    this.addTaskForm = new FormGroup({
      newTaskValue: new FormControl('',
        Validators.required)
    });
  }


  removeTask(task: Task) {
    this.taskService.removeTask(task);
    this.removeTaskFromArray(task);
  }

  removeTaskFromArray(task: Task) {
    const index: number = this.tasks.indexOf(task);
    if (index !== -1) {
      this.tasks.splice(index, 1);
    }
  }

  createTask() {
    if (this.addTaskForm.valid) {
      let aTask = new Task();
      aTask.value = this.newTask;
      aTask.done = false; //Default
      this.taskService.creatTask(aTask)
        .then(data => {
          this.addTaskForm.reset();
          this.tasks.push(data as Task)
        });
    }
  }

  updateTask(task: Task) {
    this.isUpdating = true;
    this.taskService.updateTask(task)
    .then(data=>{
      this.isUpdating=false;
    })
  }
}
