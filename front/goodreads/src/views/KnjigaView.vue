<template>
  <div v-if="knjiga">
    <!-- Display the book details -->
    <h1 id="naslov">{{ knjiga.naslov }}</h1>
    <p>Naslov: <input id="naslov" type="text" v-model="updatedNaslov"></p>
    <p>ISBN: <input id="isbn" type="text" v-model="updatedIsbn"></p>
    <p>Broj strana: <input id="brojStrana" type="number" v-model="updatedBrojStrana"></p>
    <p>Datum Objavljivanja: <input id="datumObjavljivanja" type="date" v-model="updatedDatumObjavljivanja"></p>
    <p>Opis: <input id="opis" type="text" v-model="updatedOpis"></p>
    <p>Ocena: <input disabled id="ocena" type="number" v-model="updatedOcena"></p>
    <div class="row6">
      <div class="select-wrapper">
        <select class="custom-select" v-model="updatedAutor">
          <option value="" disabled>Odaberite autora</option>
          <option v-for="autor in availableAutors" :value="autor.id" :key="autor.id">{{ autor.ime }} {{ autor.prezime }}</option>
        </select>
      </div>
    </div>
    <div class="row6">
      <div class="select-wrapper">
        <select class="custom-select" v-model="updatedZanr">
          <option disabled value="">Odaberite Zanr</option>
          <option v-for="zanr in zanrovi" :value="zanr" :key="zanr.id">
            {{ zanr.naziv }}
          </option>
        </select>
      </div>
    </div>
    <!-- Display other book properties -->

    <!-- Button to save the updated book details -->
    <button @click="sacuvajIzmene">Sacuvaj izmene</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'KnjigaView',
  data() {
    return {
      knjiga: null,
      updatedNaslov: '',
      updatedIsbn: '',
      updatedBrojStrana: '',
      updatedDatumObjavljivanja: '',
      updatedOpis: '',
      updatedOcena: '',
      updatedAutor: '',
      updatedZanr: '',
      knjige: [],
      korisnici: [],
      zanrovi: [],
      zahtevi: [],
      availableAutors: [],
      // Add other variables for other book properties
    };
  },
  created() {
    this.getKnjigaDetails();
  },
  mounted() {
    this.getZanrovi();
    this.getAutori();
  },
  methods: {
    getAutori() {
      axios
          .get("http://localhost:9090/api/korisnici", { withCredentials: true })
          .then((response) => {
            this.korisnici = response.data;
            this.availableAutors = response.data.filter(
                (korisnik) => korisnik.uloga === "AUTOR"
            );

            if (this.knjiga && this.knjiga.zanr) {
              this.updatedZanr = this.knjiga.zanr.naziv;
            }
          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch korisnici");
          });
    },

    getZanrovi() {
      axios
          .get("http://localhost:9090/api/zanrovi", { withCredentials: true })
          .then((response) => {
            this.zanrovi = response.data;
          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch zanrovi");
          });
    },
    getKnjigaDetails() {
      const knjigaId = this.$route.params.id;

      axios.get(`http://localhost:9090/api/knjige/${knjigaId}`)
          .then((response) => {
            this.knjiga = response.data;
            this.updatedNaslov = this.knjiga.naslov,
                this.updatedIsbn = this.knjiga.isbn;
            this.updatedBrojStrana = this.knjiga.brojStrana;
            this.updatedDatumObjavljivanja = this.knjiga.datumObjavljivanja;
            this.updatedOpis = this.knjiga.opis;
            this.updatedOcena = this.knjiga.ocena;
            this.updatedAutor = this.knjiga.autor;
            this.updatedZanr = this.knjiga.zanr;
            // Set other variables for other book properties
          })
          .catch((error) => {
            console.log(error);
            alert('Failed to fetch book details');
          });
    },
//     sacuvajIzmene() {
//       const knjigaId = this.$route.params.id;

//       const updatedKnjiga = {
//         naslov: this.updatedNaslov,
//         naslovnaFotografija: this.updatedNaslovnaFotografija,
//         isbn: this.updatedIsbn,
//         datumObjavljivanja: this.updatedDatumObjavljivanja,
//         brojStrana: this.updatedBrojStrana,
//         opis: this.updatedOpis,
//         autorId: this.updatedAutor.id,
//         zanrId: this.updatedZanr.id,
//       };

//       fetch(`http://localhost:9090/api/admin/knjiga/${knjigaId}/update_knjiga`, {
//         method: 'PUT',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(updatedKnjiga),
//       })
//         .then((response) => {
//           if (response.ok) {
//             console.log('Book updated successfully');
//             this.$router.push(`/homeAdministrator`);
//           } else {
//             throw new Error('Failed to update book details');
//           }
//         })
//         .catch((error) => {
//           console.log(error);
//           alert('Failed to update book details');
//         });
// }
    sacuvajIzmene() {
      const knjigaId = this.$route.params.id;

      const updatedKnjiga = {
        naslov: this.updatedNaslov,
        naslovnaFotografija: this.updatedNaslovnaFotografija,
        isbn: this.updatedIsbn,
        datumObjavljivanja: this.updatedDatumObjavljivanja,
        brojStrana: this.updatedBrojStrana,
        opis: this.updatedOpis,
        autorId: this.updatedAutor.id,
        zanrId: this.updatedZanr.id,
      };

      axios
          .put(`http://localhost:9090/api/admin/knjiga/${knjigaId}/update_knjiga`, updatedKnjiga)
          .then((res) => {
            console.log(res);
            this.$router.push("/homeAdministrator");
          })
          .catch((err) => {
            console.log(err);
            alert("Something went wrong!");
          });
    }

  }
};
</script>