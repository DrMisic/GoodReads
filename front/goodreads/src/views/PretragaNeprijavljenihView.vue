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
      <input type="text" placeholder="Pretraga recenzija">
      <input type="text" placeholder="Pretraga knjiga">
      <input type="text" placeholder="Pretraga korisnika">
      <input type="text" placeholder="Pretraga polica">
      <button type="submit">Pretraži</button>
    </form>
  </section>

  <footer>
    <p>&copy; 2023 GoodReads. Sva prava zadržana.</p>
  </footer>
</template>

<script>
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