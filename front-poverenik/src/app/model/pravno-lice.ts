import { Adresa } from './adresa';

export class PravnoLice {
  private naziv: string;
  private adresa: Adresa;

  constructor(naziv: string, adresa: Adresa) {
    this.naziv = naziv;
    this.adresa = adresa;
  }
}
