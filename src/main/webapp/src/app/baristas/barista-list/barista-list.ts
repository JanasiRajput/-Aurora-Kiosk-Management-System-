import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { BaristaService } from '../../services/barista-service';

@Component({
  selector: 'app-barista-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './barista-list.html',
  styleUrl: './barista-list.css',
})
export class BaristaList {

  baristaService = inject(BaristaService);

}