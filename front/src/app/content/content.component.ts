import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TestService } from '../servicios/test.service';
import { Question } from '../models/question.model';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  questions: Question[] = [];
  testId: number = 0;
  loading: boolean = true;
  selectedResponses: { [key: number]: number | null } = {};

  constructor(private route: ActivatedRoute, private testService: TestService) { }

  ngOnInit(): void {
    this.testService.getTest().subscribe({
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

  moveToQuestion(event: number) {
    this.testId = event;
  }

  initializeSelectedResponses(): void {
    this.questions.forEach(question => {
      this.selectedResponses[question.id] = null;
    });
  }

  selectResponse(questionId: number, responseId: number): void {
    if (this.selectedResponses[questionId] === null) {
      this.selectedResponses[questionId] = responseId;
    }
  }

  isCorrect(questionId: number): boolean | undefined {
    const responseId = this.selectedResponses[questionId];
    if (responseId === null) {
      return false;
    }

    const question = this.questions.find(q => q.id === questionId);
    return question && question.answers && question.answers[responseId].correcta;
  }

}
