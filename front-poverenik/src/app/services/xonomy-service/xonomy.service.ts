import { Injectable } from '@angular/core';
import { resenjeSpecification } from './specification/resenje-specification';

@Injectable({
  providedIn: 'root',
})
export class XonomyService {
  public resenjeSpecification: object | undefined;

  constructor() {
    this.resenjeSpecification = resenjeSpecification;
  }
}
