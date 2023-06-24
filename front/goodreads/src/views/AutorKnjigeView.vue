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
                <li id="pocetna">
                    <router-link :to="{ path: '/homeAutor', query: { autorId: autorId } }">Početna</router-link>
                </li>
                <li id="pocetna">
                    <router-link :to="{ path: '/autorKnjige', query: { autorId: autorId } }">Moje knjige</router-link>
                </li>
                <li id="pretraga">
                    <router-link :to="{ path: '/pretragaAutor', query: { autorId: autorId } }">Pretraga 🔍</router-link>
                </li>
                <li><Logout/></li>
                </ul>

              </div>
          </div>
      </div>
  </header>
  <button @click="getKnjige()">Prikazi</button>
  <div class="knjige-table" >
        <table class="center">
            <thead>
                <tr>
                    <th>Naslov</th>
                    <th>ISBN</th>
                    <th>Broj Strana</th>
                    <th>Datum Objavljivanja</th>
                    <th>Opis</th>
                    <th>Ocena</th>

                    <th>Zanr</th>
                    <th>Ažuriraj knjigu</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="knjiga in knjige" :key="knjiga.id">
                    <td>{{ knjiga.naslov }}</td>
                    <td>{{ knjiga.isbn }}</td>
                    <td>{{ knjiga.broj_strana }}</td>
                    <td>{{ knjiga.datum_objavljivanja }}</td>
                    <td>{{ knjiga.opis }}</td>
                    <td>{{ knjiga.ocena }}</td>

                    <td>{{ knjiga.zanr?.naslov }}</td>
                    <td>
                        <button @click="azurirajKnjigu(knjiga.id)">Ažuriraj knjigu</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

  </template>
  
  <script>
  import axios from 'axios';
  import Logout from '@/components/Logout.vue';

  export default {
    name: 'AutorKnjigeView',
    components:{
        Logout
    },
    data() {
        return {
            knjige: [],
            autorId: null
        };
    },
    mounted() {
      this.getKnjige();

    },
    methods: {
        getKnjige() {
            const id = this.autorId;
            axios
            .get(`http://localhost:9090/api/autor/knjige`, { withCredentials: true })
            .then((response) => {
                this.knjige = response.data;
            })
            .catch((error) => {
                console.log(error);
                alert("Failed to fetch knjige");
            });
        },
        azurirajKnjigu(knjigaId) {
            this.$router.push(`/knjigaEdit/${knjigaId}`);
        },

    },


  };
  </script>
  