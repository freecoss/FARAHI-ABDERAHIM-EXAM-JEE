import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-voitures',
  imports: [CommonModule],
  templateUrl: './voitures.html',
  styleUrl: './voitures.css',
})
export class Voitures implements OnInit {
  voitures: any[] = [];
  errorMessage: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    // Ajout d'un timestamp pour éviter le cache du navigateur
    this.http.get<any[]>('http://localhost:8085/vehicules?t=' + new Date().getTime()).subscribe({
      next: (data) => {
        console.log("Données brutes reçues du backend :", data);
        this.voitures = data; // Ne rien filtrer pour le moment pour voir tout le contenu
      },
      error: (err) => {
        console.error("Erreur HTTP détaillée :", err);
        this.errorMessage = "Impossible de joindre le backend ! Avez-vous bien REDÉMARRÉ votre serveur Spring Boot ?";
      }
    });
  }
}
