import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnInit {

  @Input() course: any;

  // Kept enrollRequested as it is still used by course-list.html to show selectedCourseId
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;
  enrolledIds$!: Observable<number[]>;

  constructor(
    public enrollmentService: EnrollmentService,
    private store: Store
  ) {}

  ngOnInit() {
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
  }

  enroll() {
    this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
    this.enrollRequested.emit(this.course.id);
  }

  unenroll() {
    this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
  }

  toggleDetails() {
    this.isExpanded = !this.isExpanded;
  }

  get cardClasses() {
    return {
      'card--enrolled': this.course.gradeStatus === 'passed',
      'card--pending': this.course.gradeStatus === 'pending',
      'card--failed': this.course.gradeStatus === 'failed',
      'expanded': this.isExpanded
    };
  }
}