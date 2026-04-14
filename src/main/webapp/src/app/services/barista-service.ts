import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// Barista model
export interface Barista {
  id?: number;
  name: string;
}

const restUrl = '/api/v1/baristas'; // match Spring Boot @RequestMapping

@Injectable({
  providedIn: 'root',
})
export class BaristaService {

  private http = inject(HttpClient);

  // Signal for reactive updates
  baristas = signal<Barista[]>([]);

  constructor() {
    this.getBaristas(); // load initial data
  }

  // Get all baristas
  getBaristas(): void {
    this.http.get<Barista[]>(restUrl).subscribe(data => {
      this.baristas.set(data);
    });
  }

  // Add a new barista
  saveBarista(barista: Barista): void {
    this.http.post<Barista>(restUrl, barista).subscribe(saved => {
      this.baristas.update(list => [...list, saved]);
    });
  }

  // Delete barista by ID
  deleteBarista(id: number): void {
    this.http.delete<void>(`${restUrl}/${id}`).subscribe(() => {
      this.getBaristas(); // refresh table after delete
    });
  }
}