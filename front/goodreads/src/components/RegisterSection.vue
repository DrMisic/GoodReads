<template>
  <div class="pre-reg">
    <div class="container4">
      <section class="register-section">
        <form onsubmit="return false;">
          <div class="row7">
            <h2>Register</h2>
          </div>
          <div class="row8">
            <input type="text" placeholder="Unesite Vase ime" v-model="ime">
          </div>
          <div class="row9">
            <input type="text" placeholder="Unesite Vase prezime" v-model="prezime">
          </div>
          <div class="row10">
            <input type="text" placeholder="Unesite Vas username" v-model="korisnickoIme">
          </div>
          <div class="row11">
            <input type="email" placeholder="Unesite Vas e-mail" v-model="email">
          </div>
          <div class="row12">
            <input type="password" placeholder="Unesite Vasu lozinku" v-model="lozinka">
          </div>
          <div class="row13">
            <input type="password" placeholder="Ponovite lozinku" v-model="lozinkaDrugiPut">
          </div>
          <div class="row14">
            <button @click="register" >REGISTER</button>
          </div>
        </form>
      </section>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'RegisterSection',
  data() {
    return {
      ime: '',
      prezime: '',
      korisnickoIme: '',
      email: '',
      lozinka: '',
      lozinkaDrugiPut: ""
    };
  },
  methods: {
    register() {
      const payload = {
        ime: this.ime,
        prezime: this.prezime,
        korisnickoIme: this.korisnickoIme,
        email: this.email,
        lozinka: this.lozinka,
        lozinkaDrugiPut:this.lozinkaDrugiPut
      };


      const payloadJSON = JSON.stringify(payload);
      console.log(payloadJSON)

      axios
          .post("http://localhost:9090/api/register", payload)
          .then((res) => {
            console.log(res);
            // Emit the 'register' event upon successful registration
            this.$emit('register');
          })
          .catch((err) => {
            console.log(err);
            alert("Something went wrong!");
          });
    }
  }
}
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
  color: rgb(36, 136, 102);
}

.container2 {
  background-color: rgb(0, 255, 173);
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

.row6 button{
  background-color:aquamarine;
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
  background-color:aquamarine;
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
}  </style>