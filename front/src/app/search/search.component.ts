import { Component, EventEmitter, Output } from '@angular/core';
import { SearchService } from './search.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  @Output() searchResults = new EventEmitter<any[]>(); 
  searchTerm: string = '';

  constructor(private searchService: SearchService) {}

  submitSearch(): void {
    if (this.searchTerm) {
      this.searchService.search(this.searchTerm).subscribe(
        results => {
          console.log(results);
          this.searchResults.emit(results);
        },
        error => {
          console.error(error);
        }
      );
    }
  }
}






