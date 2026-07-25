import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      console.error('Global Error Interceptor caught an error:', error);
      
      if (error.status === 401) {
        // HTTP 401: Navigate to the project's home page
        router.navigate(['/']);
      } else if (error.status === 500) {
        // HTTP 500: Display a simple global notification
        window.alert('A critical server error occurred (500). Please try again later.');
      }

      return throwError(() => error);
    })
  );
};
