import { Routes } from '@angular/router';
import { Home } from './home/home';
import { CourseList } from './course-list/course-list';
import { StudentProfile } from './student-profile/student-profile';
import { NotFoundComponent } from './components/not-found/not-found';
import { CourseDetailComponent } from './components/course-detail/course-detail';
import { CoursesLayoutComponent } from './components/courses-layout/courses-layout';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', component: Home },
  { 
    path: 'courses', 
    component: CoursesLayoutComponent,
    children: [
      { path: '', component: CourseList },
      { path: ':id', component: CourseDetailComponent }
    ]
  },
  { 
    path: 'enroll', 
    loadChildren: () => import('./pages/enrollment.routes').then(m => m.enrollmentRoutes),
    canActivate: [authGuard]
  },
  { 
    path: 'enroll-reactive', 
    redirectTo: 'enroll/reactive',
    pathMatch: 'full'
  },
  { 
    path: 'profile', 
    component: StudentProfile,
    canActivate: [authGuard]
  },
  { path: '**', component: NotFoundComponent }
];
