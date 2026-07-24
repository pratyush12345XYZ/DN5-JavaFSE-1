import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    CourseCard
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {

  courses = [

    {
      id: 1,
      name: 'Angular Fundamentals',
      code: 'ANG101',
      credits: 4
    },

    {
      id: 2,
      name: 'Spring Boot',
      code: 'SPR201',
      credits: 5
    },

    {
      id: 3,
      name: 'Microservices',
      code: 'MIC301',
      credits: 4
    }

  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {

    console.log('Enrolling in course:', courseId);

    this.selectedCourseId = courseId;

  }

}