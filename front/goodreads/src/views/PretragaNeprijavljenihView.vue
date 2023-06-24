<template>
  <header>
    <div class="pre-header">
      <div class="container1">
        <div class="row1">
          <div class="imageheader1">

          </div>
          <div class="imagelogo">
            <div class="col-md-4">
              <img src="../assets/logo.png">
            </div>
          </div>
          <div class="imageheader2">

          </div>
        </div>
      </div>
    </div>
    <div class="container2">
      <div class="row2">
        <div>
          <ul class="menu">
            <li id="pocetna"><a href="/">Prijavi se</a></li>
            <li id="pretraga"><a href="/pretragaNeprijavljeni">Pretraga 🔍</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>

  <section class="search-section">
    <h2>Pretraga</h2>
    <form>
      <div>
      <input type="text" v-model="naslov" placeholder="Pretraga knjiga">

      <button @click="searchNaslov" type="submit">Pretraži</button>
      </div>
      <div style="padding-top: 30px">
        <button @click="getKorisnici" type="submit">Prikazi korisnike</button>
        <table v-show="res1" id="zanrovi_prikaz" class="center" style="padding-top: 30px">
          <thead>
          <tr>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Email</th>
            <th>Uloga</th>
          </tr>
          </thead>
          <tbody>

            <tr v-for="korisnik in korisnici" :key="korisnik.id">
              <td>{{ korisnik.ime }}</td>
              <td>{{ korisnik.prezime }}</td>
              <td>{{ korisnik.email }}</td>
              <td>{{ korisnik.uloga }}</td>
            </tr>


          </tbody>
        </table>

      </div>
      <div style="padding-top: 30px">
        <button @click="getZanrovi()"   type="submit">Prikazi zanrove</button>
        <table id="zanrovi_prikaz" class="center" style="padding-top: 30px">
          <thead>
          <tr>
            <th>Naziv</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="zanr in zanrovi" :key="zanr.id">
            <td>{{ zanr.naslov }}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </form>
  </section>

  <footer>
    <p>&copy; 2023 GoodReads. Sva prava zadržana.</p>
  </footer>
</template>

<script>
import axios from "axios";

export default {
  name: 'PretragaNeprijavljenihView',
  components: {

  },
  data(){
    return {
      knjiga: "",
      zanrovi:[],
      korisnici:[],
      res1 : false
    };
  },
  mounted() {
    this.getZanrovi();
    this.getKorisnici();
    this.searchNaslov();
  },
  methods:{
    getZanrovi()
    {
      axios
          .get("http://localhost:9090/api/zanrovi", { withCredentials: true })
          .then((response) => {
            this.zanrovi= response.data;



          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch police");
          });
    },

    getKorisnici()
    {
      axios
          .get("http://localhost:9090/api/korisnici", { withCredentials: true })
          .then((response) => {
            this.korisnici= response.data;
            this.res1 = true;


          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch police");
          });
    },

    searchNaslov(naslov)
    {

      axios
          .get(`http://localhost:9090/api/knjiga/naslov/${naslov}`, { withCredentials: true })
          .then((response) => {
            this.knjiga= response.data;
            this.$router.push(`/knjigaPregled/${knjigaId}`);




          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch police");
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