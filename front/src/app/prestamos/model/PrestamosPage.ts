import { Pageable } from "src/app/core/model/page/Pageable";
import { Prestamos } from "./Prestamos";

export class PrestamosPage {
  content: Prestamos[];
  pageable: Pageable;
  totalElements: number;
}