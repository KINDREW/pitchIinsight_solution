<template>
  <div id="app">
    <InputForm @save-to-database="saveToDatabase" />
    <div class="numbers">
      <button v-if="notShowingInputs" @click="toggleShowInputs">
        Display Numbers
      </button>
      <button v-else @click="toggleShowInputs">Hide Numbers</button>
      <div v-if="showInputs">
        <h2>User Inputs</h2>
        <div v-for="input in displayedItems" :key="input">
          {{ input }}
        </div>
        <Button @click="loadNextPage">Next </Button>
        <Button @click="loadPreviousPage"> Previous </Button>
        <br />
        Page:{{ currentPage }}
      </div>
    </div>
  </div>
</template>

<script>
import InputForm from "./components/Inputform.vue";

export default {
  name: "App",
  components: {
    InputForm,
  },
  data() {
    return {
      userInputs: [],
      showInputs: false,
      notShowingInputs: true,
      displayedItems: [],
      itemsPerPage: 20,
      currentPage: 1,
      totalPages: 1,
    };
  },
  methods: {
    saveToDatabase(inputValue) {
      if (inputValue !== null && inputValue !== undefined) {
        // Send the input value to the backend for database insertion
        fetch(
          "http://localhost:8080/userinput",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ input: inputValue }),
          },
          this.fetchUserInputs()
        ).then((response) => {
          if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
          }
          return console.log("Data saved successfully:");
        });
      } else {
        console.warn(
          "Input value is null or undefined. Not saving to the database."
        );
      }
    },
    fetchUserInputs() {
      //fetching data from db
      fetch(`http://localhost:8080/userinput`)
        .then((response) => response.json())
        .then((data) => {
          this.userInputs = data.map((item) => item.input);
          this.userInputs = this.userInputs.sort((a, b) => a - b);
          this.totalPages = Math.ceil(
            this.userInputs.length / this.itemsPerPage
          );
          this.loadCurrentPage();
        })
        .catch((error) => {
          console.error("Error fetching user inputs:", error);
        });
    },
    loadCurrentPage() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      this.fetchUserInputs();
      this.displayedItems = this.userInputs.slice(startIndex, endIndex);
    },
    loadNextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
        this.loadCurrentPage();
      }
    },
    loadPreviousPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
        this.loadCurrentPage();
      }
    },

    toggleShowInputs() {
      this.showInputs = !this.showInputs;
      this.notShowingInputs = !this.notShowingInputs;

      if (this.userInputs.length === 0) {
        this.fetchUserInputs();
      }
    },
  },
};
</script>

<style>
.numbers {
  margin: 20px;
}

.numbers button {
  margin: 5px;
}
</style>
