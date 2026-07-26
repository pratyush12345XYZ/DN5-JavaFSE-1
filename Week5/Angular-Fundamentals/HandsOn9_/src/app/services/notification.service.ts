import { Injectable } from '@angular/core';

// Note: No providedIn: 'root' because this service is meant to be 
// provided at the component level to demonstrate hierarchical DI.
@Injectable()
export class NotificationService {
  private static instanceCounter = 0;
  public instanceId: number;
  private message: string = 'No notification yet.';

  constructor() {
    NotificationService.instanceCounter++;
    this.instanceId = NotificationService.instanceCounter;
  }

  setMessage(msg: string) {
    this.message = msg;
  }

  getMessage(): string {
    return this.message;
  }
}
