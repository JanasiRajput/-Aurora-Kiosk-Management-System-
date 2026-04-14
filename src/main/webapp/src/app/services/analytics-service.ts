import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {
  private apiUrl = '/api/v1';

  constructor(private http: HttpClient) {}

  getSalesSummary(): Observable<any> {
    return this.http.get(`${this.apiUrl}/sales/summary`);
  }

  getRevenueSummary(): Observable<any> {
    return this.http.get(`${this.apiUrl}/analytics/revenue`);
  }

  getTopKiosks(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/analytics/insights`);
  }

  getAlerts(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/analytics/alerts`);
  }

  getPeakTimes(): Observable<any> {
    return this.http.get(`${this.apiUrl}/analytics/peak-times`);
  }

  getRevenueTrend(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/analytics/revenue/trend`);
  }
}
