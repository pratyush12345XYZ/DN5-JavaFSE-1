import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-detail.html',
  styles: [`
    .detail-container { border: 1px solid #ccc; padding: 20px; border-radius: 8px; max-width: 600px; margin: 20px auto; background-color: #fafafa; }
    .back-link { margin-top: 20px; display: inline-block; padding: 8px 15px; background: #007bff; color: white; text-decoration: none; border-radius: 4px; }
  `]
})
export class CourseDetailComponent implements OnInit {
  course: Course | undefined;

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    // Read the :id parameter from the route snapshot
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      const courseId = parseInt(idParam, 10);
      // Fetch the matching course using the service
      this.course = this.courseService.getCourseById(courseId);
    }
  }
}
