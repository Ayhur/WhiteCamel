import { Component } from '@angular/core';
import { TestService } from '../servicios/test.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

  listMenu: any[] = [];

  constructor(private testService:TestService) { }

  ngOnInit() {
    this.testService.listMenu().subscribe({
      next: ((response:any) => 
        this.listMenu = response
      )
    });
  }

  /**
   * Trae el test seleccionado.
   * @param testId 
   */
  onTemarioClick(testId: number): void {
    this.testService.getTest(testId).subscribe({
      next: ((response:any) => {
        console.log("EL listado de preguntas/Respuestas:", response); 
        this.testService.setPreguntasYRespuestas(response);
      })
    });
  }
  
}
