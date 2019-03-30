import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../model/task-model';
import { Router } from '@angular/router';
import { TaskService } from '../service/task.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {
  allTasks: TaskModel[];
  confirmationStatus;
  constructor(private router: Router, private taskService: TaskService) {
    this.allTasks = [];
    this.allTasks = this.taskService.display();
  }

  ngOnInit() {
  }
  addTask() {
    // navigate to home page on click of Go to Home button
    this.router.navigate(['/create']);
  }
  deleteTask(index: number) {
    // ask user confirmation on delete
    this.confirmationStatus = confirm('Do you want to delete the task?');
    if (this.confirmationStatus) {
      this.taskService.delete(index);
    }
  }
  editTask(index: number) {
    this.taskService.editTask(index);
  }
 
 
 

}
