import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject, of } from 'rxjs';
import { switchMap, catchError } from 'rxjs/operators';
import { CourseCard } from '../components/course-card/course-card';
import { HighlightDirective } from '../directives/highlight';
import { CourseService } from '../services/course.service';
import { EnrollmentService } from '../services/enrollment.service';
import { Course } from '../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CourseCard,
    HighlightDirective
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = false;
  courses: Course[] = [];
  filteredCourses: Course[] = [];
  selectedCourseId: number | null = null;
  searchTerm: string = '';

  errorMessage = '';

  private courseSelectedSubject = new Subject<number>();
  enrolledStudents: any[] = [];

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoading = true;
    this.errorMessage = '';

    // switchMap cancels previous pending requests if a new course is selected rapidly, preventing race conditions.
    this.courseSelectedSubject.pipe(
      switchMap(courseId => this.enrollmentService.getStudentsByCourse(courseId).pipe(
        catchError(err => {
          console.error('Failed to load students for course:', err);
          return of([]);
        })
      ))
    ).subscribe(students => {
      this.enrolledStudents = students;
      console.log('Enrolled students for selected course:', students);
    });

    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.courses = courses;
        this.filteredCourses = this.courses;

        // Read the query parameter
        const searchParam = this.route.snapshot.queryParamMap.get('search');
        if (searchParam) {
          this.searchTerm = searchParam;
          this.applyFilter();
        }
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching courses', err);
        this.errorMessage = 'Failed to load courses. Please try again later.';
        this.isLoading = false;
      }
    });
  }

  onSearchChange(): void {
    // Update the URL using Router.navigate
    this.router.navigate(['courses'], {
      queryParams: {
        search: this.searchTerm || null
      },
      queryParamsHandling: 'merge'
    });
    
    this.applyFilter();
  }

  applyFilter(): void {
    if (!this.searchTerm) {
      this.filteredCourses = this.courses;
    } else {
      const term = this.searchTerm.toLowerCase();
      this.filteredCourses = this.courses.filter(c => 
        c.name.toLowerCase().includes(term) || 
        c.code.toLowerCase().includes(term)
      );
    }
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
    this.courseSelectedSubject.next(courseId);
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

}