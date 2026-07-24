import { Routes } from '@angular/router';
import { EnrollmentFormComponent } from './enrollment-form/enrollment-form';
import { ReactiveEnrollmentFormComponent } from './reactive-enrollment-form/reactive-enrollment-form';
import { unsavedChangesGuard } from '../guards/unsaved-changes.guard';

export const enrollmentRoutes: Routes = [
  { 
    path: '', 
    component: EnrollmentFormComponent 
  },
  { 
    path: 'reactive', 
    component: ReactiveEnrollmentFormComponent,
    canDeactivate: [unsavedChangesGuard]
  }
];
