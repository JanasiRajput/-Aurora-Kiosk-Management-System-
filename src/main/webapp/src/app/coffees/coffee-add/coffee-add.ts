import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { CoffeeService } from '../../services/coffee-service';

@Component({
  selector: 'app-coffee-add',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './coffee-add.html',
  styleUrl: './coffee-add.css',
})
export class CoffeeAdd {

  // Inject services
  private http = inject(HttpClient);
  private coffeeService = inject(CoffeeService);

  // Store baristas for dropdown
  baristas: any[] = [];

  // Coffee object (bind to form)
  coffee = {
    name: '',
    price: 0,
    quantity: 0,
    employeeName: ''
  };

  // Load baristas when page loads
  ngOnInit() {
    this.http.get<any[]>('/api/v1/baristas')
      .subscribe(data => {
        this.baristas = data;
      });
  }

  // Add coffee
  addCoffee() {
    this.coffeeService.saveCoffee(this.coffee);

    // reset form (optional but nice)
    this.coffee = {
      name: '',
      price: 0,
      quantity: 0,
      employeeName: ''
    };
  }
}