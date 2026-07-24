import {
  Component,
  OnInit,
  OnDestroy,
  OnChanges,
  SimpleChanges
} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../services/course.service';
import { CourseSummaryWidgetComponent } from '../components/course-summary-widget/course-summary-widget';
import { NotificationComponent } from '../components/notification/notification';
import { Course } from '../models/course.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, CourseSummaryWidgetComponent, NotificationComponent],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy, OnChanges {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  message = '';

  status = 'Active';

  courses: Course[] = [];

  constructor(private courseService: CourseService) {
    console.log('Constructor called');
  }

  ngOnInit(): void {
    console.log('HomeComponent initialized - courses loaded');
    // Store the reference to the courses array in ngOnInit instead of calling the service in the template
    this.courses = this.courseService.getCourses();
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges', changes);
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}