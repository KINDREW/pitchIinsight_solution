<template>
  <div>
    <label for="inputValue">Enter an integer:</label>
    <input v-model="inputValue" type="number" id="inputValue" />
    <button @click="saveToDatabase">Save</button>
  </div>
</template>

<script>
export default {
  name: "InputForm",

  data() {
    return {
      inputValue: null,
    };
  },
  methods: {
    saveToDatabase() {
      this.$emit("save-to-database", this.inputValue);
      this.inputValue = null;
    },
  },
};
</script>

<style></style>
