import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnalyticsService } from '../services/analytics-service';

@Component({
  selector: 'app-analytics',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './analytics.html',
  styleUrl: './analytics.css',
})
export class Analytics implements OnInit {
  salesSummary: any = {};
  revenueSummary: any = {};
  topKiosks: any[] = [];
  alerts: string[] = [];
  revenueTrend: any[] = [];
  peakTimes: any = {};
  loading = true;

  constructor(
    private analyticsService: AnalyticsService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.loading = true;
    
    // Using forkJoin or parallel subscribes
    this.analyticsService.getSalesSummary().subscribe({
      next: data => { this.salesSummary = data; this.checkLoading(); },
      error: err => { console.error('Sales Error', err); this.checkLoading(); }
    });

    this.analyticsService.getRevenueSummary().subscribe({
      next: data => { this.revenueSummary = data; this.checkLoading(); },
      error: err => { console.error('Revenue Error', err); this.checkLoading(); }
    });

    this.analyticsService.getTopKiosks().subscribe({
      next: data => { this.topKiosks = data; this.checkLoading(); },
      error: err => { console.error('Kiosks Error', err); this.checkLoading(); }
    });

    this.analyticsService.getAlerts().subscribe({
      next: data => { this.alerts = data; this.checkLoading(); },
      error: err => { console.error('Alerts Error', err); this.checkLoading(); }
    });

    this.analyticsService.getRevenueTrend().subscribe({
      next: data => { this.revenueTrend = data; this.checkLoading(); },
      error: err => { console.error('Trend Error', err); this.checkLoading(); }
    });

    this.analyticsService.getPeakTimes().subscribe({
      next: data => { this.peakTimes = data; this.checkLoading(); },
      error: err => { console.error('Peak Error', err); this.checkLoading(); }
    });
  }

  private checkLoading(): void {
    // Basic logic to stop spinner when most data is in
    if (this.topKiosks.length > 0 || Object.keys(this.salesSummary).length > 0) {
      this.loading = false;
      this.cdr.detectChanges(); // Force UI update
    }
  }

  getPeakTimeKeys(): string[] {
    return Object.keys(this.peakTimes).sort((a,b) => parseInt(a) - parseInt(b));
  }

  getTrendPath(): string {
    if (!this.revenueTrend || this.revenueTrend.length === 0) return '';
    const maxRev = Math.max(...this.revenueTrend.map(t => t.revenue));
    const width = 800;
    const height = 150;
    const step = width / (this.revenueTrend.length - 1);
    
    return this.revenueTrend.map((t, i) => {
      const x = i * step;
      const y = height - (t.revenue / maxRev * height);
      return `${i === 0 ? 'M' : 'L'} ${x} ${y}`;
    }).join(' ');
  }

  getRevenueKeys(): string[] {
    return Object.keys(this.revenueSummary);
  }

  getSummaryKeys(): string[] {
    return Object.keys(this.salesSummary);
  }
}
