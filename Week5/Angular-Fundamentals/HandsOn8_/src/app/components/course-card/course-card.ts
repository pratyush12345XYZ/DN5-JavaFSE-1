import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {

  @Input() course: any;

  // Kept enrollRequested as it is still used by course-list.html to show selectedCourseId
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(public enrollmentService: EnrollmentService) {}

  enroll() {
    this.enrollmentService.enroll(this.course.id);
    this.enrollRequested.emit(this.course.id);
  }

  unenroll() {
    this.enrollmentService.unenroll(this.course.id);
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