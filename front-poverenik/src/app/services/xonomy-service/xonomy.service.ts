import { Injectable } from '@angular/core';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root',
})
export class XonomyService {
  constructor() {}

  public resenjeSpecification = {
    elements: {
      Resenje: {
        menu: [
          {
            caption: 'Додај <trazilac>',
            action: Xonomy.newElementChild,
            actionParameter: '<trazilac></trazilac>',
            hideIf: (el: any) => el.hasChildElement('trazilac'),
          },
          {
            caption: 'Додај <poverenik>',
            action: Xonomy.newElementChild,
            actionParameter: '<poverenik></poverenik>',
            hideIf: (el: any) => el.hasChildElement('poverenik'),
          },
          {
            caption: 'Додај <ustanova>',
            action: Xonomy.newElementChild,
            actionParameter: '<ustanova></ustanova>',
            hideIf: (el: any) => el.hasChildElement('ustanova'),
          },
          {
            caption: 'Додај <dispozitiv>',
            action: Xonomy.newElementChild,
            actionParameter: '<dispozitiv></dispozitiv>',
            hideIf: (el: any) => el.hasChildElement('dispozitiv'),
          },
          {
            caption: 'Додај <obrazlozenje>',
            action: Xonomy.newElementChild,
            actionParameter: '<obrazlozenje></obrazlozenje>',
            hideIf: (el: any) => el.hasChildElement('obrazlozenje'),
          },
          {
            caption: 'Додај атрибут @ID',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'ID', value: 'ID001' },
            hideIf: (el: any) => el.hasAttribute('ID'),
          },
          {
            caption: 'Додај атрибут @broj',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'broj', value: 'R/000-001' },
            hideIf: (el: any) => el.hasAttribute('broj'),
          },
          {
            caption: 'Додај атрибут @datum',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'datum', value: '2021-01-01' },
            hideIf: (el: any) => el.hasAttribute('datum'),
          },
          {
            caption: 'Додај атрибут @datum_zahteva',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'datum_zahteva', value: '2021-01-01' },
            hideIf: (el: any) => el.hasAttribute('datum_zahteva'),
          },
          {
            caption: 'Додај атрибут @datum_zalbe',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'datum_zalbe', value: '2021-01-01' },
            hideIf: (el: any) => el.hasAttribute('datum_zalbe'),
          },
          {
            caption: 'Додај атрибут @datum_postupka',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'datum_postupka', value: '2021-01-01' },
            hideIf: (el: any) => el.hasAttribute('datum_postupka'),
          },
        ],
        attributes: {
          ID: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @ID',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
          broj: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @broj',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
          datum: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @datum',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
          datum_zahteva: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @datum_zahteva',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
          datum_zalbe: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @datum_zalbe',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
          datum_postupka: {
            asker: Xonomy.askString,
            menu: [
              {
                caption: 'Обриши атрибут @datum_postupka',
                action: Xonomy.deleteAttribute,
              },
            ],
          },
        },
      },
      trazilac: {
        mustBeBefore: ['poverenik', 'ustanova', 'dispozitiv', 'obrazlozenje'],
        menu: [
          {
            caption: 'Додај <ime>',
            action: Xonomy.newElementChild,
            actionParameter: '<ime> </ime>',
            hideIf: (el: any) => el.hasChildElement('ime'),
          },
          {
            caption: 'Додај <prezime>',
            action: Xonomy.newElementChild,
            actionParameter: '<prezime> </prezime>',
            hideIf: (el: any) => el.hasChildElement('prezime'),
          },
        ],
        attributes: [],
        elements: {
          ime: { hasText: true },
          prezime: { hasText: true },
        },
      },
      poverenik: {
        mustBeBefore: ['ustanova', 'dispozitiv', 'obrazlozenje'],
        menu: [
          {
            caption: 'Додај <ime>',
            action: Xonomy.newElementChild,
            actionParameter: '<ime> </ime>',
            hideIf: (el: any) => el.hasChildElement('ime'),
          },
          {
            caption: 'Додај <prezime>',
            action: Xonomy.newElementChild,
            actionParameter: '<prezime> </prezime>',
            hideIf: (el: any) => el.hasChildElement('prezime'),
          },
        ],
        attributes: [],
        elements: {
          ime: { hasText: true, asker: Xonomy.askString },
          prezime: { hasText: true, asker: Xonomy.askString },
        },
      },
      ustanova: {
        mustBeBefore: ['dispozitiv', 'obrazlozenje'],
      },
      dispozitiv: {
        mustBeBefore: ['obrazlozenje'],
        menu: [
          {
            caption: 'Додај <stav>',
            action: Xonomy.newElementChild,
            actionParameter: '<stav></stav>',
          },
        ],
        attributes: [],
        elements: {
          stav: {
            menu: [
              {
                caption: 'Додај <dokument>',
                action: Xonomy.newElementChild,
                actionParameter: '<dokument></dokument>',
                hideIf: (el: any) => el.hasChildElement('dokument'),
              },
              {
                caption: 'Додај <rokObavestenja>',
                action: Xonomy.newElementChild,
                actionParameter: '<rokObavestenja></rokObavestenja>',
                hideIf: (el: any) => el.hasChildElement('rokObavestenja'),
              },
              {
                caption: 'Додај <tekst>',
                action: Xonomy.newElementChild,
                actionParameter: '<tekst></tekst>',
                hideIf: (el: any) => el.hasChildElement('tekst'),
              },
            ],
            attributes: [],
            elements: {
              dokument: {
                menu: [
                  {
                    caption: 'Додај <naziv>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<naziv></naziv>',
                    hideIf: (el: any) => el.hasChildElement('naziv'),
                  },
                  {
                    caption: 'Додај <informacija>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<informacija></informacija>',
                  },
                ],
                attributes: [],
                elements: {
                  naziv: { hasText: true, asker: Xonomy.askString },
                  informacija: { hasText: true, asker: Xonomy.askString },
                },
              },
              rokObavestenja: { hasText: true, asker: Xonomy.askString },
              tekst: { hasText: true, asker: Xonomy.askString },
            },
          },
        },
      },
      obrazlozenje: {
        menu: [
          {
            caption: 'Додај <paragraf>',
            action: Xonomy.newElementChild,
            actionParameter: '<paragraf> </paragraf>',
          },
        ],
        attributes: [],
        elements: {
          paragraf: { hasText: true, asker: Xonomy.askString },
        },
      },
    },
  };
}
