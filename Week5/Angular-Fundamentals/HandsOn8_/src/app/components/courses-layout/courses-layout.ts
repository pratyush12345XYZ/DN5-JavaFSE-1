import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-courses-layout',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './courses-layout.html',
  styles: [`
    .courses-layout { border: 2px dashed #007bff; padding: 15px; border-radius: 8px; margin-bottom: 20px; background-color: #f8f9fa; }
    .layout-header { color: #007bff; margin-top: 0; font-size: 1.1rem; text-transform: uppercase; letter-spacing: 1px; }
  `]
})
export class CoursesLayoutComponent {}
