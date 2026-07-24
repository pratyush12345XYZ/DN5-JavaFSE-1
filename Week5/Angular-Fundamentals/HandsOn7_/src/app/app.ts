import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Header } from './header/header';
import { Home } from './home/home';
import { CourseList } from './course-list/course-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    Header
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}