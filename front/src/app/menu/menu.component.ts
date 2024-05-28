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

  @Input() ratedQuestions: boolean[] | null = null;

  @Output() notifier = new EventEmitter<number>()

  constructor(private testService:TestService) { }

  setClass(index: number) {
    let color = "";
    if (this.ratedQuestions === null) {
      if (index == this.currentItem) {
        color = "menu-item-current-color";
      } else {
        color = "menu-item-color";
      }
    } else {
      if (this.ratedQuestions[index]) {
        color = "menu-item-correct-color";
      } else {
        color = "menu-item-incorrect-color";
      }
    }

    return `menu-item ${color}`;
  }
}
