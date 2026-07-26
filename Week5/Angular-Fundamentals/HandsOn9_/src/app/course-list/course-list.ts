import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject, of, BehaviorSubject, combineLatest, Observable } from 'rxjs';
import { switchMap, catchError, map } from 'rxjs/operators';
import { Store } from '@ngrx/store';
import { CourseCard } from '../components/course-card/course-card';
import { HighlightDirective } from '../directives/highlight';
import { EnrollmentService } from '../services/enrollment.service';
import { Course } from '../models/course.model';
import { selectAllCourses, selectCoursesLoading, selectCoursesError } from '../store/course/course.selectors';
import { loadCourses } from '../store/course/course.actions';

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

  isLoading$: Observable<boolean>;
  error$: Observable<string | null>;
  
  searchTerm: string = '';
  private searchSubject = new BehaviorSubject<string>('');
  
  courses$: Observable<Course[]>;

  selectedCourseId: number | null = null;
  private courseSelectedSubject = new Subject<number>();
  enrolledStudents: any[] = [];

  constructor(
    private store: Store,
    private enrollmentService: EnrollmentService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.isLoading$ = this.store.select(selectCoursesLoading);
    this.error$ = this.store.select(selectCoursesError);

    this.courses$ = combineLatest([
      this.store.select(selectAllCourses),
      this.searchSubject
    ]).pipe(
      map(([courses, term]) => {
        if (!term) return courses;
        const lowerTerm = term.toLowerCase();
        return courses.filter(c => 
          c.name.toLowerCase().includes(lowerTerm) || 
          c.code.toLowerCase().includes(lowerTerm)
        );
      })
    );
  }

  ngOnInit(): void {
    this.store.dispatch(loadCourses());

    const searchParam = this.route.snapshot.queryParamMap.get('search');
    if (searchParam) {
      this.searchTerm = searchParam;
      this.searchSubject.next(this.searchTerm);
    }

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
  }

  onSearchChange(): void {
    this.router.navigate(['courses'], {
      queryParams: {
        search: this.searchTerm || null
      },
      queryParamsHandling: 'merge'
    });
    
    this.searchSubject.next(this.searchTerm);
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