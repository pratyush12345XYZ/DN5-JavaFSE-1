import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoadingService } from '../../services/loading.service';

@Component({
  selector: 'app-loading-spinner',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div *ngIf="loadingService.isLoading$ | async" class="global-spinner">
      Loading...
    </div>
  `
})
export class LoadingSpinnerComponent {
  constructor(public loadingService: LoadingService) {}
}
