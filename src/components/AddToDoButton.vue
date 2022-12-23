<template>
  <div>
    <form @submit="addToDo">
      <input type="text" v-model="title" name="title">
      <button type="submit">Hinzufuegen</button>
    </form>
  </div>
</template>

<script>
  import {v4 as uuidv4} from "uuid";
  export default{
    name: "AddToDoButton",
    data(){
      return {
        title: ""
      }
    },
    emits:["add-todo-event"],
    methods: {
      addToDo(event) {
        event.preventDefault();

        const newTodoObject = {
          id: uuidv4(),
          title: this.title,
          completed: false
        }
        this.$emit("add-todo-event", newTodoObject);
        this.title=""
      },
    }
  }
</script>