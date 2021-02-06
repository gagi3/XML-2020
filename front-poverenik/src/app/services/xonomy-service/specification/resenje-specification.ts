import {
  adresaSpecification,
  fizickoLiceSpecification,
  pravnoLiceSpecification,
  tuzbaSpecification,
} from './common-specification';

declare const Xonomy: any;

const validateAttribute = (el: any, attribute: string) => {
  if (!el.attributes.find((a: any) => a.name === attribute)) {
    Xonomy.warnings.push({
      htmlID: el.htmlID,
      text: `Атрибут @${attribute} је обавезан!`,
    });
  }
};

const validateChild = (el: any, child: string) => {
  if (!el.children.find((c: any) => c.name === child)) {
    Xonomy.warnings.push({
      htmlID: el.htmlID,
      text: `Елемент @${child} је обавезан!`,
    });
  }
};

export const resenjeSpecification = {
  validate: (el: any) => {
    validateAttribute(el, 'ID');
    validateAttribute(el, 'broj');
    validateAttribute(el, 'datum');
    validateAttribute(el, 'datum_zahteva');
    validateAttribute(el, 'datum_zalbe');
    validateAttribute(el, 'datum_postupka');

    validateChild(el, 'trazilac');
    validateChild(el, 'poverenik');
    validateChild(el, 'ustanova');
    validateChild(el, 'dispozitiv');
    validateChild(el, 'obrazlozenje');
  },
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
      ...fizickoLiceSpecification,
    },
    poverenik: {
      mustBeBefore: ['ustanova', 'dispozitiv', 'obrazlozenje'],
      ...fizickoLiceSpecification,
    },
    ustanova: {
      mustBeBefore: ['dispozitiv', 'obrazlozenje'],
      ...pravnoLiceSpecification,
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
      elements: {},
    },
    obrazlozenje: {
      menu: [
        {
          caption: 'Додај <paragraf>',
          action: Xonomy.newElementChild,
          actionParameter: '<paragraf></paragraf>',
        },
        {
          caption: 'Додај <tuzba>',
          action: Xonomy.newElementChild,
          actionParameter: '<tuzba></tuzba>',
          hideIf: (el: any) => el.hasChildElement('tuzba'),
        },
      ],
      attributes: [],
      elements: {},
    },
    ime: { hasText: true, oneliner: true, asker: Xonomy.askString },
    prezime: { hasText: true, oneliner: true, asker: Xonomy.askString },
    adresa: adresaSpecification,
    grad: { hasText: true, oneliner: true, asker: Xonomy.askString },
    ulica: { hasText: true, oneliner: true, asker: Xonomy.askString },
    broj: { hasText: true, oneliner: true, asker: Xonomy.askString },
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
      elements: {},
    },
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
      elements: {},
    },
    naziv: { hasText: true, oneliner: true, asker: Xonomy.askString },
    informacija: { hasText: true, oneliner: true, asker: Xonomy.askString },
    rokObavestenja: { hasText: true, oneliner: true, asker: Xonomy.askString },
    tekst: { hasText: true, oneliner: true, asker: Xonomy.askString },
    paragraf: { hasText: true, oneliner: true, asker: Xonomy.askString },
    tuzba: tuzbaSpecification,
    rok: { hasText: true, oneliner: true, asker: Xonomy.askString },
    taksa: { hasText: true, oneliner: true, asker: Xonomy.askString },
  },
};
