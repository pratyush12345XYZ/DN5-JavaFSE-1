import { Observable, forkJoin, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private apiUrl = 'http://localhost:3000/enrollments';
  private http = inject(HttpClient);
  private enrolledCourseIds: number[] = [];

  constructor(private courseService: CourseService) {}

  submitEnrollment(enrollmentData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, enrollmentData);
  }

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    const index = this.enrolledCourseIds.indexOf(courseId);
    if (index !== -1) {
      this.enrolledCourseIds.splice(index, 1);
    }
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Observable<Course[]> {
    if (this.enrolledCourseIds.length === 0) return of([]);
    const observables = this.enrolledCourseIds.map(id => this.courseService.getCourseById(id));
    return forkJoin(observables);
  }

  getStudentsByCourse(courseId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}?courseId=${courseId}`);
  }
}
