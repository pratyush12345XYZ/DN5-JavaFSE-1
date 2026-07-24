import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './notification.html',
  
  // Providing NotificationService at the component level here in the providers array.
  // This creates a separate, new instance of NotificationService exclusively for this component
  // and its children. It is not a singleton shared with the rest of the application.
  providers: [NotificationService],
  
  styles: [`
    .notification-box { 
      border: 1px solid orange; 
      padding: 10px; 
      margin-top: 15px; 
      border-radius: 4px;
      background-color: #fff3cd; 
    }
    h4 { margin-top: 0; }
  `]
})
export class NotificationComponent implements OnInit {
  constructor(public notificationService: NotificationService) {}

  ngOnInit(): void {
    this.notificationService.setMessage('Welcome to the notifications widget!');
  }

  updateMessage(): void {
    this.notificationService.setMessage('You have 1 new unread message.');
  }
}
