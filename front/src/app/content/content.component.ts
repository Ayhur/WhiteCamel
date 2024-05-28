import { Component } from '@angular/core';
import { TestService } from '../servicios/test.service';
import { ScoresService } from '../servicios/scores.service';
import { AuthService } from '../servicios/auth.service';
import { Question } from '../models/question.model';
import { Response } from '../models/response.model';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  questions: Question[] = [];
  testId: number = 0;
  loading: boolean = true;
  testDone: boolean = false;
  selectedResponses: { [key: number]: number | null } = {};
  finalScore: number = 0;
  scoreMessage: string = "";

  constructor(
    private testService: TestService,
    private scoresService: ScoresService,
    private authService: AuthService,
  ) { }

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

  initializeSelectedResponses(): void {
    this.questions.forEach(question => {
      this.selectedResponses[question.questionId] = null;
    });
  }

  selectResponse(questionId: number, responseId: number): void {
    this.selectedResponses[questionId] = responseId;
  }

  isCorrect(questionId: number): boolean | undefined {
    const question = this.questions.find(q => q.questionId === questionId);
    return question && question.correction && this.selectedResponses[questionId] === question.correction.correctResponseId;
  }

  getAnswerStyle(response: Response) {
    const question = this.questions[this.testId];
    const selectedResponse = this.selectedResponses[question.questionId];
    if (selectedResponse === null || selectedResponse !== response.responseId) {
      return "";
    }

    if (!this.testDone) {
      return "selected-answer";
    }

    if (this.isCorrect(question.questionId)) {
      return "correct-answer";
    }

    return "incorrect-answer";
  }

  moveToQuestion(event: number) {
    this.testId = event;
  }

  prevQuestion() {
    if (this.testId > 0) {
      this.testId--;
    }
  }

  nextQuestion() {
    if (this.testId < this.questions.length - 1) {
      this.testId++;
    }
  }

  finishTest() {
    this.testDone = true;
    const rightAnswers = this.questions
      .map(question => this.isCorrect(question.questionId))
      .filter(value => value)
      .length

    this.finalScore = (rightAnswers / this.questions.length) * 100;
    console.log(this.finalScore);

    this.scoresService.saveScore(this.authService.currentUserValue.dni, this.finalScore)

    if (this.finalScore < 90) {
      this.scoreMessage = "Mejor suerte la próxima";
    } else {
      this.scoreMessage = "¡Enhorabuena!";
    }
  }
}