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
            <li id="pocetna"><a href="/homeCitalac">Početna</a></li>
            <li id="pretraga"><a href="/pretragaCitalac">Pretraga </a></li>
            <li><Logout/></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container3">
      <div>
        <h3 style="text-align: center; padding-top: 20px; padding-bottom: 10px; font-weight: bold;">
          Police
        </h3>
        <div class="zahtevi-table">
          <table class="center">
            <thead>
            <tr>
              <th> Naziv </th>
              <th> Primarna </th>
              <th> Pogledaj stavke police </th>
              <th> Obrisi policu </th>

            </tr>
            </thead>
            <tbody>
            <tr v-for="polica in police  " :key="polica.id">
              <td>{{ polica.naziv }}</td>
              <td>{{ polica.daLiJePrimarno }}</td>
              <td>
                <button @click="stavkePolice(polica.id)">Pogledaj stavke police</button>
              </td>
              <td>
                <button @click="obrisiPolicu(polica.id)">Obrisi policu</button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="container4" style="padding-top: 40px">
      <h4 style="text-align: center; padding-top: 20px; padding-bottom: 10px; font-weight:bold;">
        Dodaj policu</h4>

        <input type="text" v-model="policaNaziv" placeholder="Unesite naziv police">
        <button @click="addPolica">Dodaj policu</button>

    </div>
  </header>

  <footer>
    <p>&copy; 2023 GoodReads. Sva prava zadržana.</p>
  </footer>
</template>

<script>
import Logout from '@/components/Logout.vue';
import axios from "axios";

export default {
  name: 'HomeCitalacView',
  components: {
    Logout
  },
  data(){
    return {
      police: [],
      stavkePolice:[],
    };
  },
  mounted() {
    this.getPolice();
    this.getStavkaPolice();
  },
  methods:{
    getPolice()
    {
      axios
          .get("http://localhost:9090/api/my-police", { withCredentials: true })
          .then((response) => {
            this.police = response.data;

          })
          .catch((error) => {
            console.log(error);
            alert("Failed to fetch police");
          });
    },
    addPolica(){
          const p = {
            naziv:  this.policaNaziv,
          };
          axios
            .post("http://localhost:9090/api/save-polica", p ,{ withCredentials: true })
            .then((response) => {
              this.getPolice();
              this.naziv = "";

            })
            .catch((error) => {
              console.log(error);
              alert("Failed to fetch police");
            });
    },
    getStavkaPolice()
    {

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
  text-decoration: none;
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

.pre-log {
  display: flex;
  justify-content: center;
  align-items: center;
}

.pre-reg {
  display: flex;
  justify-content: center;
  align-items: center;
}

h1 {
  font-size: 60px;
  margin-left: 15px;
  font-weight: bold;
}

h2 {
  font-size: 60px;
  margin-left:15px;
  font-weight: bold;
}

.container2 button{
  font-weight: bold;
  font-style: 8px;
  font-size: 15px;
  color: rgb(96, 108, 93);
}

.row4 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-top: 20px;
  margin-bottom: 20px;
  text-align: center;
}

.row5 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  text-align: center;
}

.row6 button{
  background-color:rgb(96, 108, 93);
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  margin-bottom: 20px;
  margin-left: 8px;
  border-radius: 8px;
}

.row8 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row9 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row10 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row11 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row12 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row13 input {
  border: 2px solid rgb(127, 255, 212);
  border-radius: 8px;
  margin-bottom: 20px;
  margin-left: 25px;
  text-align: center;
}

.row14 button{
  background-color:rgb(96, 108, 93);
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  margin-bottom: 20px;
  margin-left: 28px;
  border-radius: 8px;
}

footer {
  text-align: center;
  margin-top: 40px;
  font-weight: bold;
}
</style>
