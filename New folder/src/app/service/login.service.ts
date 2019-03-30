import { Injectable } from '@angular/core';
import { TaskModel } from '../model/task-model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  correctCredentials: TaskModel;
  constructor() {
    // sets default correct credentials
    this.correctCredentials = new TaskModel();
    this.correctCredentials.email = 'admin@gmail.com';
    this.correctCredentials.password = '123456';
  }
}
