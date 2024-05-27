import { Answer } from "./response.model";

export interface Question {
  id: number;
  descripcion: string;
  answers: Answer[];
}
