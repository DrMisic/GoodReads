<template>
    <header>
        <div class="pre-header">
            <div class="container1">
                <div class="row1">
                    <div class="imageheader1">

                    </div>
                    <div class="imagelogo">
                        <div class="col-md-4">
                            <img src="../assets/logo.png" />
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="container2">
            <div class="row2">
                <div>
                    <ul class="menu">
                        <li id="pocetna"><a href="/">Prijavi se</a></li>
                        <li id="pocetna"><a href="/pregledNeprijavljeni">Pregled</a></li>
                        <li id="pretraga"><a href="/pretragaNeprijavljeni">Pretraga 🔍</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    <h3 style="text-align: center; padding-top: 20px; padding-bottom: 10px; font-weight:bold;">
        Knjige
    </h3>
    <div class="knjige-table">
        <table class="center">
            <thead>
                <tr>
                    <th>Naslov</th>
                    <th>ISBN</th>
                    <th>Broj Strana</th>
                    <th>Datum Objavljivanja</th>
                    <th>Opis</th>
                    <th>Ocena</th>
                    <th>Autor</th>
                    <th>Zanr</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="knjiga in knjige" :key="knjiga.id">
                    <td>{{ knjiga.naslov }}</td>
                    <td>{{ knjiga.isbn }}</td>
                    <td>{{ knjiga.brojStrana }}</td>
                    <td>{{ knjiga.datumObjavljivanja }}</td>
                    <td>{{ knjiga.opis }}</td>
                    <td>{{ knjiga.ocena }}</td>
                    <td>{{ knjiga.autor.ime }}</td>
                    <td>{{ knjiga.zanr?.naziv }}</td>
                    <td>
                        <button @click="seeMoreKnjiga(knjiga.id)">Vidi još</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <h3 style="text-align: center; padding-top: 20px; padding-bottom: 10px; font-weight: bold;">
        Korisnici
    </h3>
    <div class="korisnici-table">
        <table class="center">
            <thead>
                <tr>
                    <th>Ime</th>
                    <th>Prezime</th>
                    <th>Korisnicko Ime</th>
                    <th>Datum Rodjenja</th>
                    <th>Opis</th>
                    <th>Uloga</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="korisnik in korisnici" :key="korisnik.id">
                    <td>{{ korisnik.ime }}</td>
                    <td>{{ korisnik.prezime }}</td>
                    <td>{{ korisnik.korisnickoIme }}</td>
                    <td>{{ korisnik.datumRodjenja }}</td>
                    <td>{{ korisnik.opis }}</td>
                    <td>{{ korisnik.uloga }}</td>
                    <td>
                        <button @click="seeMoreKorisnik(korisnik.id)">Vidi još</button>
                    </td>
                    <td v-if="korisnik.uloga === 'AUTOR'">
                        <ZahtevView :id="korisnik.id"></ZahtevView>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <h3 style="text-align: center; padding-top: 20px; padding-bottom: 10px; font-weight: bold;">
        Zanrovi
    </h3>
    <div class="zanrovi-table">
        <table class="center">
            <thead>
                <tr>
                    <th>Naziv</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="zanr in zanrovi" :key="zanr.id">
                    <td>{{ zanr.naziv }}</td>
                </tr>
            </tbody>
        </table>
    </div>

    <footer>
        <p>&copy; 2023 BookBuddy. Sva prava zadržana.</p>
    </footer>
</template>

<script>
import axios from "axios";
import ZahtevView from './ZahtevView.vue';


export default {
    name: "PregledNeprijavljeniView",
    components: {
        ZahtevView,
    },
    data() {
        return {
            knjige: [],
            korisnici: [],
            zanrovi: [],
            zahtevi: [],
            availableAutors: [],
            autorIme: '',
            autorPrezime: '',
            autorMail: '',
            autorKorisnickoIme: '',
            autorLozinka: '',
        };
    },
    mounted() {
        this.getKnjige();
        this.getKorisnici();
        this.getZanrovi();
        this.getAutori();
    },
    methods: {
        podnesiZahtev(korisnikId) {
        this.$router.push({ path: '/zahtev', params: { id: korisnikId } });
        },
        seeMoreKnjiga(knjigaId) {
            this.$router.push(`/knjigaPregled/${knjigaId}`);
        },
        seeMoreKorisnik(korisnikId) {
            this.$router.push(`/korisnikPregled/${korisnikId}`);
        },
        getKnjige() {
            axios
                .get("http://localhost:9090/api/knjige", { withCredentials: true })
                .then((response) => {
                    this.knjige = response.data;
                })
                .catch((error) => {
                    console.log(error);
                    alert("Failed to fetch knjige");
                });
        },
        getKorisnici() {
            axios
                .get("http://localhost:9090/api/korisnici", { withCredentials: true })
                .then((response) => {
                    this.korisnici = response.data;
                })
                .catch((error) => {
                    console.log(error);
                    alert("Failed to fetch korisnici");
                });
        },
        getAutori() {
            axios
                .get("http://localhost:9090/api/korisnici", { withCredentials: true })
                .then((response) => {
                    this.korisnici = response.data;
                    this.availableAutors = response.data.filter((korisnik) => korisnik.uloga === "AUTOR");
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
        
        },
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
    justify-content: space-around;
    list-style: none;
    padding: 0;
}

a {
    font-weight: bold;
    font-style: italic;
    font-size: 15px;
    color:rgb(96, 108, 93);
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
    margin-left: 15px;
    font-weight: bold;
}

.container2 button {
    font-weight: bold;
    font-style: 8px;
    font-size: 15px;
    color: rgb(36, 136, 102);
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

.row6 button {
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

    align-items: center;
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

.row14 button {
    background-color: rgb(96, 108, 93);
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

.knjige-table,
.korisnici-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.knjige-table th,
.knjige-table td,
.korisnici-table th,
.korisnici-table td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.knjige-table th,
.korisnici-table th {
    background-color: #f2f2f2;
    font-weight: bold;
}

.knjige-table button {
    background-color: rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
    color: black;
}

.knjige-table tbody tr:hover,
.korisnici-table tbody tr:hover {
    background-color: #f5f5f5;
}

table.center {
    margin-left: auto;
    margin-right: auto;
}

.container2 li button {
    background-color: rgb(96, 108, 93);
    border: 2px solid rgb(36, 136, 102);
    text-decoration: none;
    cursor: pointer;
    border-radius: 8px;
    color: black;
}

.knjige-table .dodaj_knjigu button {
    background-color: rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    cursor: pointer;
    border-radius: 8px;
    color: black;
    margin-top: 15px;
}

table,
th,
td {
    border: 2px solid black;
}

.korisnici-table button {
    background-color: rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
    color: black;
}

.zanrovi-table button {
    background-color:rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
    color: black;
}

.container3 input {
    border: 1px solid black;
    border-radius: 8px;
    margin-bottom: 20px;
    margin-left: 25px;
    text-align: center;
}

.container4 input {
    border: 1px solid black;
    border-radius: 8px;
    margin-bottom: 20px;
    margin-left: 25px;
    text-align: center;
}

.dodaj_autora button {
    background-color: rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    cursor: pointer;
    border-radius: 8px;
    color: black;
    margin-top: 15px;
}

.zahtevi-table button {
    background-color: rgb(96, 108, 93);
    padding: 8px 14px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
    color: black;
}



</style>
