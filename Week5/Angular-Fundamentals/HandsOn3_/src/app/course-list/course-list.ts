import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../components/course-card/course-card';
import { HighlightDirective } from '../directives/highlight';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    CourseCard,
    HighlightDirective
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = false;

  courses = [
    {
      id: 1,
      name: 'Angular Fundamentals',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Spring Boot',
      code: 'SPR201',
      credits: 5,
      gradeStatus: 'pending'
    },
    {
      id: 3,
      name: 'Microservices',
      code: 'MIC301',
      credits: 4,
      gradeStatus: 'failed'
    }
  ];

  selectedCourseId: number | null = null;

  ngOnInit(): void {
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

}