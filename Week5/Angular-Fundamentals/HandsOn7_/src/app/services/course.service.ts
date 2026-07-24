import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private courses: Course[] = [
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
    },
    {
      id: 4,
      name: 'TypeScript Basics',
      code: 'TS101',
      credits: 3,
      gradeStatus: 'passed'
    },
    {
      id: 5,
      name: 'Docker & Kubernetes',
      code: 'DKR401',
      credits: 5,
      gradeStatus: 'pending'
    }
  ];

  constructor() {}

  getCourses(): Course[] {
    return this.courses;
  }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(course => course.id === id);
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}
