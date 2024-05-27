import { Component, EventEmitter, Input, Output } from '@angular/core';
import { TestService } from '../servicios/test.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

  @Input() currentItem: number = 0;

  @Input() itemCount: number = 0;

  @Output() notifier = new EventEmitter<number>()

  constructor(private testService:TestService) { }
  
}
