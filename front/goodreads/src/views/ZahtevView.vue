<template>
    <div>
      <h3>Zahtev za aktivaciju autora</h3>
      <form onsubmit="return false;">
        <div>
          <label>Email:</label>
          <input type="text" v-model="el1" required />
        </div>
        <div>
          <label>Broj Telefona:</label>
          <input type="number" v-model="el2" required />
        </div>
        <div>
          <label>Dodatna Poruka:</label>
          <textarea v-model="el3"></textarea>
        </div>
        <button @click="submitZahtev"  type="button">Submit</button>
      </form>
    </div>
  </template>

<script>
import axios from 'axios';

export default {

  name: 'ZahtevView',
  props: ['id'], // Add this line to receive the prop
  data() {
    return {
      zahtev: {
        mail: '',
        brojTelefona: '',
        dodatnaPoruka: '',
        korisnik_id: this.id // Use the prop value to set korisnik_id
      }
    };
  },
  methods: {
    submitZahtev() {

      const z = {
        email: this.el1,
        brojTelefona: this.el2,
        poruka:this.el3
      };
      axios
        .post(`http://localhost:9090/api/podnesi_zahtev_za_aktivaciju_naloga_autora`, z, { withCredentials: true })
        .then((response) => {
          console.log(response.data);
          // Handle successful response
          this.mail = "";
              this.telefon = "";
              this.poruka = "";
        })
        .catch((error) => {
          console.error(error);
          // Handle error
          alert("Failed to add knjiga");
        });
    }
  }
};

</script>
