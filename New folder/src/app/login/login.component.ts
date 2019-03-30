import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../model/task-model';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  input:TaskModel;
  incorrectEmailStatus=false;
  incorrectPasswordStatus = false;
  requiredEmailStatus = false;
  requiredPasswordStatus = false;
  constructor(private router: Router,private loginService:LoginService)  {
    this.input=new TaskModel();
    this.input.email='';
    this.input.password='';
   }

  ngOnInit() {
  }
  navigateToHome() {
    // navigate to home page on click of Go to Home button
    this.router.navigate(['/home']);
 }
 validate() {
  // validates email
 if (this.input.email !== '') {
  if (this.loginService.correctCredentials.email !== this.input.email) {
    this.incorrectEmailStatus = true;
    this.requiredEmailStatus = false;
  }
 } else {
  this.requiredEmailStatus = true;
 }
 // validates password
 if (this.input.password !== '') {
  if (this.loginService.correctCredentials.password !== this.input.password) {
    this.incorrectPasswordStatus = true;
    this.requiredPasswordStatus = false;
  }
 } else {
  this.requiredPasswordStatus = true;
 }
 // validates for correct credentials
  if (this.loginService.correctCredentials.email === this.input.email &&
    this.loginService.correctCredentials.password === this.input.password) {
      alert('Login successfull!');
      this.router.navigate(['/userdetails']);
  }
}
clear() {
  this.input.email = '';
  this.input.password = '';
  this.incorrectEmailStatus = false;
  this.incorrectPasswordStatus = false;
  this.requiredEmailStatus = false;
  this.requiredPasswordStatus = false;
}

}
