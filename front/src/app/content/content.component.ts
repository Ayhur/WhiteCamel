import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TestService } from '../servicios/test.service';
import { Question } from '../models/question.model';
import { Response } from '../models/response.model';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  questions: Question[] = [];
  testId: number | null = null;
  loading: boolean = true;
  selectedResponses: { [key: number]: number | null } = {};

  constructor(private route: ActivatedRoute, private testService: TestService) { }

  ngOnInit(): void {

    this.testService.preguntasYRespuestas$.subscribe({
      next: (data: Question[]) => {
        this.questions = data;
        this.loading = false;
        this.initializeSelectedResponses();
    },
    error: (error) => {
      console.error('Error al obtener preguntas y respuestas:', error);
      this.loading = false;
    }
   });

  }

  initializeSelectedResponses(): void {
    this.questions.forEach(question => {
      this.selectedResponses[question.questionId] = null;
    });
  }

  selectResponse(questionId: number, responseId: number): void {
    if (this.selectedResponses[questionId] === null) {
      this.selectedResponses[questionId] = responseId;
    }
  }

  isCorrect(questionId: number): boolean | undefined {
    const question = this.questions.find(q => q.questionId === questionId);
    return question && question.correction && this.selectedResponses[questionId] === question.correction.correctResponseId;
  }

}
