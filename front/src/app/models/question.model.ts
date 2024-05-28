import { Correction } from "./correction.model";
import { Response } from "./response.model";

export interface Question {
  questionId: number;
  questionText: string;
  responses: Response[];
  correction: Correction;
}