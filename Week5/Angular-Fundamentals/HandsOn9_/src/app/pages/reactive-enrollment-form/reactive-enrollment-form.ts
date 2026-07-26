import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormArray, AbstractControl, ValidationErrors, FormControl } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { delay, map } from 'rxjs/operators';

import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrls: ['./reactive-enrollment-form.css']
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder, private enrollmentService: EnrollmentService) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [this.simulateEmailCheck]],
      courseId: ['', [Validators.required, this.noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Custom Synchronous Validator
  noCourseCode(control: AbstractControl): ValidationErrors | null {
    if (control.value && typeof control.value === 'string' && control.value.startsWith('XX')) {
      return { noCourseCode: true };
    }
    return null;
  }

  // Custom Async Validator
  simulateEmailCheck(control: AbstractControl): Observable<ValidationErrors | null> {
    return of(control.value).pipe(
      delay(800),
      map(value => {
        if (value && typeof value === 'string' && value.includes('test@')) {
          return { emailTaken: true };
        }
        return null;
      })
    );
  }

  // Getter for additional courses
  // Using a getter here is better than casting in the template because it keeps the template cleaner,
  // avoids redundant evaluation in the HTML, and ensures we have strong typing within our component.
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(new FormControl('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    if (this.enrollForm.valid) {
      console.log('Submitting enrollment...', this.enrollForm.value);
      
      this.enrollmentService.submitEnrollment(this.enrollForm.value).subscribe({
        next: (response) => {
          console.log('Enrollment successfully saved to backend!', response);
          window.alert('Enrollment successful!');
          this.enrollForm.reset();
        },
        error: (err) => {
          console.error('Failed to submit enrollment:', err);
          window.alert('Failed to submit enrollment. Please try again.');
        }
      });
    }
  }
}
