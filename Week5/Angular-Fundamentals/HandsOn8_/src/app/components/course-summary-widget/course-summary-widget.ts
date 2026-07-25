import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  template: `
    <div class="widget">
      <h4>Course Summary Widget</h4>
      <p>Live Course Count: <strong>{{ courses.length }}</strong></p>
      
      <!-- 
        This button exists specifically to demonstrate the Hands-On 6 requirement: 
        "Adding a course in one place must update the count everywhere." 
        We can remove it at the end of the hands-on if desired, but it proves the singleton works.
      -->
      <button (click)="addNewCourse()">Add Test Course</button>
    </div>
  `,
  styles: [`
    .widget {
      border: 1px solid #aaa;
      padding: 10px;
      margin-top: 15px;
      border-radius: 4px;
      background-color: #f0f8ff;
    }
    h4 { margin-top: 0; }
  `]
})
export class CourseSummaryWidgetComponent implements OnInit {
  courses: Course[] = [];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    // Store the reference to the courses array instead of calling service in template
    this.courseService.getCourses().subscribe(courses => this.courses = courses);
  }

  addNewCourse() {
    this.courseService.createCourse({
      name: 'New Dynamic Course',
      code: 'DYN999',
      credits: 3,
      gradeStatus: 'pending'
    } as Course).subscribe(() => {
      this.courseService.getCourses().subscribe(courses => this.courses = courses);
    });
  }
}
