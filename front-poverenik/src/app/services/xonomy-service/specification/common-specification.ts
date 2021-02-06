declare const Xonomy: any;

export const adresaSpecification = {
  menu: [
    {
      caption: 'Додај <grad>',
      action: Xonomy.newElementChild,
      actionParameter: '<grad></grad>',
      hideIf: (el: any) => el.hasChildElement('grad'),
    },
    {
      caption: 'Додај <ulica>',
      action: Xonomy.newElementChild,
      actionParameter: '<ulica></ulica>',
      hideIf: (el: any) => el.hasChildElement('ulica'),
    },
    {
      caption: 'Додај <broj>',
      action: Xonomy.newElementChild,
      actionParameter: '<broj></broj>',
      hideIf: (el: any) => el.hasChildElement('broj'),
    },
  ],
  attributes: [],
  elements: {},
};

export const fizickoLiceSpecification = {
  menu: [
    {
      caption: 'Додај <ime>',
      action: Xonomy.newElementChild,
      actionParameter: '<ime></ime>',
      hideIf: (el: any) => el.hasChildElement('ime'),
    },
    {
      caption: 'Додај <prezime>',
      action: Xonomy.newElementChild,
      actionParameter: '<prezime></prezime>',
      hideIf: (el: any) => el.hasChildElement('prezime'),
    },
    {
      caption: 'Додај <adresa>',
      action: Xonomy.newElementChild,
      actionParameter: '<adresa></adresa>',
      hideIf: (el: any) => el.hasChildElement('adresa'),
    },
  ],
  attributes: [],
  elements: {},
};

export const pravnoLiceSpecification = {
  menu: [
    {
      caption: 'Додај <naziv>',
      action: Xonomy.newElementChild,
      actionParameter: '<naziv></naziv>',
      hideIf: (el: any) => el.hasChildElement('naziv'),
    },
    {
      caption: 'Додај <adresa>',
      action: Xonomy.newElementChild,
      actionParameter: '<adresa></adresa>',
      hideIf: (el: any) => el.hasChildElement('adresa'),
    },
  ],
  attributes: [],
  elements: {},
};

export const tuzbaSpecification = {
  menu: [
    {
      caption: 'Додај <rok>',
      action: Xonomy.newElementChild,
      actionParameter: '<rok></rok>',
      hideIf: (el: any) => el.hasChildElement('rok'),
    },
    {
      caption: 'Додај <taksa>',
      action: Xonomy.newElementChild,
      actionParameter: '<taksa></taksa>',
      hideIf: (el: any) => el.hasChildElement('taksa'),
    },
  ],
  attributes: [],
  elements: {},
};
