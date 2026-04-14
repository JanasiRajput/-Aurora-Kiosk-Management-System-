import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// Coffee model
export interface Coffee {
  id?: number;
  name: string;
  price: number;
  quantity: number;
  employeeName: string;
}

const restUrl = '/api/v1/coffees'; // match Spring Boot @RequestMapping

@Injectable({
  providedIn: 'root',
})
export class CoffeeService {

  private http = inject(HttpClient);

  // Signal for reactive updates
  coffees = signal<Coffee[]>([]);

  constructor() {
    this.getCoffees(); // load initial data
  }

  // Get all coffees
  getCoffees(): void {
    this.http.get<Coffee[]>(restUrl).subscribe(data => {
      this.coffees.set(data);
    });
  }

  // Add new coffee
  saveCoffee(coffee: Coffee): void {
    this.http.post<Coffee>(restUrl, coffee).subscribe(saved => {
      this.coffees.update(list => [...list, saved]);
    });
  }

  // Delete coffee by ID
  deleteCoffee(id?: number): void {
    if (!id) return;
    this.http.delete<void>(`${restUrl}/${id}`).subscribe(() => {
      this.coffees.update(list => list.filter(c => c.id !== id));
    });
  }
  }
