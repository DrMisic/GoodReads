<template>
  <header>
    <div class="pre-header">
      <div class="container1">
        <div class="row1">
          <div class="imageheader1">
            <div class="col-md-4">
              <img src="../assets/headerLeftRight.png">
            </div>
          </div>
          <div class="imagelogo">
            <div class="col-md-4">
              <img src="../assets/logo.png">
            </div>
          </div>
          <div class="imageheader2">
            <div class="col-md-4">
              <img src="../assets/headerLeftRight.png">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container2">
      <div class="row2">
        <div>
          <ul class="menu">
            <li id="pocetna"><a href="/homeAdministrator">Početna</a></li>
            <li id="pretraga"><a href="/pretragaAdministrator">Pretraga 🔍</a></li>
            <li><Logout/></li>
          </ul>
        </div>
      </div>
    </div>
  </header>

  <section class="search-section">
    <h2>Pretraga</h2>
    <form @submit.prevent="searchKnjige">
      <input type="text" placeholder="Pretraga knjiga" v-model="searchQuery">
      <button type="submit">Pretraži</button>
    </form>
  </section>

  <div v-if="searched && knjige.length > 0">
    <div class="knjige-table">
      <table class="center">
        <thead>
        <tr>
          <th>ID</th>
          <th>Naslov</th>
          <th>ISBN</th>
          <th>Broj Strana</th>
          <th>Datum Objavljivanja</th>
          <th>Opis</th>
          <th>Ocena</th>
          <th>Zanr</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="knjiga in knjige" :key="knjiga.id">
          <td>{{ knjiga.id }}</td>
          <td>{{ knjiga.naslov }}</td>
          <td>{{ knjiga.isbn }}</td>
          <td>{{ knjiga.brojStrana }}</td>
          <td>{{ knjiga.datumObjavljivanja }}</td>
          <td>{{ knjiga.opis }}</td>
          <td>{{ knjiga.ocena }}</td>
          <td>{{ knjiga.zanr?.naziv }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>

  <footer>
    <p>&copy; 2023 BookBuddy. Sva prava zadržana.</p>
  </footer>
</template>

<script>
import axios from 'axios';
import Logout from '@/components/Logout.vue';

export default {
  name: 'HomeAdministratorView',
  components: {
    Logout
  },
  data() {
    return {
      searchQuery: '',
      knjige: [],
      searched: false
    };
  },
  methods: {
    searchKnjige() {
      axios
          .get(`http://localhost:9090/api/search-knjige/${this.searchQuery}`)
          .then((response) => {
            if (response.data.length == 0) {
              alert('Ne postoji knjiga sa tim imenom');
              this.searched = false; // Set searched to false if knjige array is empty
            } else {
              this.knjige = response.data;
              this.searched = true;
            }
          })
          .catch((error) => {
            console.log(error);
            alert('Ne postoji ta knjiga');
          });
    }
  }
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
}

.pre-header {
  background-color: rgb(96, 108, 93);
  height: 190px;
}

.menu {
  display: flex;
  justify-content:space-around;
  list-style: none;
  padding: 0;
}

a{
  font-weight: bold;
  font-style: italic;
  font-size: 15px;
  color: rgb(96, 108, 93);
}

.container2 {
  background-color: rgb(247, 230, 196);
  opacity: 50%;
  height: 40px;
  padding-top: 8px;
}

.container1 .row1 {
  display: flex;
  justify-content: center;
  align-items: center;
}

.container1 .col-md-4 {
  flex: 1;
}

.imagelogo img {
  height: 90px;
}

.container1 .col-md-4:nth-child(2) img {
  display: block;
  margin: 0 auto;
}

.imageheader1 img {
  opacity: 0.75;
  padding-top: 15px;
}

.imageheader2 {
  opacity: 0.75;
  padding-top: 15px;
}

footer {
  text-align: center;
  margin-top: 40px;
  font-weight: bold;
}

.search-section ::placeholder{
  text-align: center;
}
</style>