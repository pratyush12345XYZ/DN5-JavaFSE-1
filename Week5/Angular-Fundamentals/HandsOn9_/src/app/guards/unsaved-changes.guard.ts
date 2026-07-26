import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentFormComponent } from '../pages/reactive-enrollment-form/reactive-enrollment-form';

export const unsavedChangesGuard: CanDeactivateFn<ReactiveEnrollmentFormComponent> = (component) => {
  // If the component's enrollForm exists and has been modified (is dirty)
  if (component.enrollForm && component.enrollForm.dirty) {
    return window.confirm('You have unsaved changes. Leave?');
  }
  // If the form is not dirty (or doesn't exist yet), allow navigation
  return true;
};
