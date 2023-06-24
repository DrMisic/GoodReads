<template>
  <div v-if="knjiga">
    <h1>{{ knjiga.naslov }}</h1>
    <p><strong>Naslovna fotografija:</strong> {{ knjiga.naslovnaFotografija }}</p>
    <p><strong>ISBN:</strong> {{ knjiga.ISBN }}</p>
    <p><strong>Datum objavljivanja:</strong> {{ knjiga.datumObjavljivanja }}</p>
    <p><strong>Broj strana:</strong> {{ knjiga.brojStrana }}</p>
    <p><strong>Opis:</strong> {{ knjiga.opis }}</p>
    <p><strong>Ocena:</strong> {{ knjiga.ocena }}</p>
    <p><strong>Zanr:</strong> {{ knjiga.zanr.naziv }}</p>

    <h2>Recenzije</h2>
    <ul>
      <li v-for="recenzija in knjiga.recenzije" :key="recenzija.id">
        <p><strong>Ocena:</strong> {{ recenzija.ocena }}</p>
        <p><strong>Tekst:</strong> {{ recenzija.tekst }}</p>
        <p><strong>Datum:</strong> {{ recenzija.datum }}</p>
        <p><strong>Korisnik:</strong> {{ recenzija.korisnik?.ime }} {{ recenzija.korisnik?.prezime }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'KnjigaView',
  data() {
    return {
      knjiga: null
    };
  },
  created() {
    this.getKnjigaDetails();
  },
  methods: {
    getKnjigaDetails() {
      const knjigaId = this.$route.params.id;

      axios
        .get(`http://localhost:9090/api/knjiga/${knjigaId}`)
        .then((response) => {
          this.knjiga = response.data;
          this.getRecenzijeKnjige();
        })
        .catch((error) => {
          console.log(error);
          alert('Failed to fetch book details');
        });
    },
    getRecenzijeKnjige() {
      const knjigaId = this.$route.params.id;

      axios
        .get(`http://localhost:9090/api/recenzija/knjiga/${knjigaId}`)
        .then((response) => {
          const recenzije = response.data;
          this.knjiga.recenzije = recenzije;
        })
        .catch((error) => {
          console.log(error);
          alert('Failed to fetch book reviews');
        });
    }
    
  }
};
</script>
