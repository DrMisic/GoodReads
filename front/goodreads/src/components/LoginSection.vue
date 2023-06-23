<template>
  <div class="pre-log">
    <div class="container3">
      <section class="login-section">
        <form>
          <div class="row3">
            <h1>PRIJAVI SE</h1>
          </div>
          <div class="row4">
            <input type="email" placeholder="Unesite Vas e-mail" v-model="email">
          </div>
          <div class="row5">
            <input type="password" placeholder="Unesite Vasu lozinku" v-model="password">
          </div>
          <div class="row6">
            <button @click.prevent="submit">PRIJAVI SE</button>
          </div>
        </form>
      </section>
    </div>
  </div>
</template>
<script>
export default {
  name: 'LoginSection',
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    submit() {
      const payload = {
        email: this.email,
        password: this.password
      };
      const json = JSON.stringify(payload);
      console.log(json)
      fetch('http://localhost:9090/api/login', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },

        body: json
      })
          .then((res) => {
            console.log(res);
            if (res.ok) {
              return res.json();
            } else {
              throw new Error('Login failed');
            }
          })
          .then((data) => {
            console.log(data);
            localStorage.setItem('user', JSON.stringify(data));
            if (data.uloga === 'CITALAC') {
              this.$router.push('/homeCitalac?korisnikId=${data.id}');
            } else if (data.uloga === 'AUTOR') {
              this.$router.push('/homeAutor?korisnikId=${data.id}');
            } else if (data.uloga === 'ADMINISTRATOR') {
              this.$router.push('/homeAdministrator?korisnikId=${data.id}');
            } else {
              this.$router.push('/');
            }
          })
          .catch((err) => {
            console.log(err);
            alert('Something went wrong!');
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
  //display: flex;
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
  color: rgb(96, 108, 93);;
}

h2 {
  font-size: 60px;
  margin-left:15px;
  font-weight: bold;
}

.container2 button{
  align-content: center;
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