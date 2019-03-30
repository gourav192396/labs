import { Injectable } from '@angular/core';
import { TaskModel } from '../model/task-model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  taskArray: TaskModel[];
  constructor(private router: Router) {
    this.taskArray = [];
  }
  add(task: TaskModel) {
    // add task to array
    this.taskArray.push(task);
    this.router.navigate(['/userdetails']);
  }
  display() {
    return this.taskArray;
  }
  delete(index: number) {
    // delete a particular task
    this.taskArray.splice(index, 1);
  }
  editTask(index: number) {
    // add id of task through route to prefill and edit particular task
  this.router.navigate(['/edit'], { queryParams: { id: index }});
  }
  getDetailsOf(index) {
    // get details of particular task
    return this.taskArray[index];
  }
  edit(index: number, updatedTask: TaskModel) {
    // update edited task details to array
    this.taskArray[index] = updatedTask;
    this.router.navigate(['/userdetails']);
  }
}
