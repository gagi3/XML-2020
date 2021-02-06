import { Component, OnInit } from '@angular/core';
import { XonomyService } from 'src/app/services/xonomy-service/xonomy.service';
import { ResenjeService } from 'src/app/services/resenje-service/resenje.service';

declare const Xonomy: any;

@Component({
  selector: 'app-create-resenje',
  templateUrl: './create-resenje.component.html',
  styleUrls: ['./create-resenje.component.scss'],
})
export class CreateResenjeComponent implements OnInit {
  private editor: HTMLElement | undefined | null;
  private specification: object | undefined | null;

  constructor(
    private xonomyService: XonomyService,
    private resenjeService: ResenjeService
  ) {}

  ngOnInit(): void {
    this.editor = document.getElementById('editor');
    this.specification = this.xonomyService.resenjeSpecification;
    Xonomy.render(
      '<Resenje xmlns:r="http://www.pijz.rs/resenje"></Resenje>',
      this.editor,
      this.specification
    );
  }

  submitXML(): void {
    const XML = Xonomy.harvest();
    console.log(XML);
    // this.resenjeService.create(XML).subscribe((data) => {
    //  console.log(data);
    // });
  }
}
