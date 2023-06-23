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
            <li id="pocetna"><a href="/homeAutor">Početna</a></li>
            <li id="pretraga"><a href="/pretragaAutor">Pretraga </a></li>
            <li><Logout/></li>
          </ul>
        </div>
      </div>
    </div>
  </header>

  <footer>
    <p>&copy; 2023 BookBuddy. Sva prava zadržana.</p>
  </footer>
</template>

<script>
import Logout from '@/components/Logout.vue';

export default {
  name: 'HomeAutorView',
  components: {
    Logout
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
}
</style>
