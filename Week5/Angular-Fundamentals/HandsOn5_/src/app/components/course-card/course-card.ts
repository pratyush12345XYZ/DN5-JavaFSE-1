import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {

  @Input() course: any;

  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  enroll() {
    this.enrollRequested.emit(this.course.id);
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