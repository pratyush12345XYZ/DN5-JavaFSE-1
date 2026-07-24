import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseCard } from '../components/course-card/course-card';
import { HighlightDirective } from '../directives/highlight';
import { CourseService } from '../services/course.service';
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

  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.courses = this.courseService.getCourses();
    this.filteredCourses = this.courses;

    // Read the query parameter
    const searchParam = this.route.snapshot.queryParamMap.get('search');
    if (searchParam) {
      this.searchTerm = searchParam;
      this.applyFilter();
    }
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
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

}