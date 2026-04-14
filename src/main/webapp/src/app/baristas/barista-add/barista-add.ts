import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BaristaService } from '../../services/barista-service';
@Component({
  selector: 'app-barista-add',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './barista-add.html',
  styleUrl: './barista-add.css',
})
export class BaristaAdd {

  private baristaService = inject(BaristaService);

  // Model
  barista = {
    name: ''
  };

  // Add method
  addBarista() {
    this.baristaService.saveBarista(this.barista);

    // Reset form
    this.barista = { name: '' };
  }
}