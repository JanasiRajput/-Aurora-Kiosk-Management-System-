import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CoffeeService } from '../../services/coffee-service';

@Component({
  selector: 'app-coffee-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './coffee-list.html',
  styleUrl: './coffee-list.css',
})
export class CoffeeList {

  coffeeService = inject(CoffeeService);

}