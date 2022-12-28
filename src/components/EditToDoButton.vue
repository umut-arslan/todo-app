<template>
  <form @submit.prevent="editToDoButton">
    <input type="text" :value="getTitle" name="titleInput">
    <button type="submit">editieren</button>
  </form>
</template>

<script>
export default {
  computed: {
    getTitle() {
      return this.entries.filter(todo => todo.id === this.id).map(todo=> todo.title);
    },
  },
  props: [
    "entries",
    "id",
  ],
  methods: {
    editToDoButton(e) {
      this.$emit("editToDoEvent", e.target.titleInput.value);
    },
  }
}
</script>

<style>

</style>