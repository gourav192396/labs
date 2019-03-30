import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'practice';
  constructor(private router: Router) {

  }
  navigateToLogin() {
    // navigate to login page on click of login button
    this.router.navigate(['/login']);
  }
}

