import { Correction } from "./correciton.model";
import { Response } from "./response.model";


export interface Question {
  questionId: number;
  questionText: string;
  responses: Response[];
  correction: Correction;
}
