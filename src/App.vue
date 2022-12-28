<template>
  <div id="app">
    <ToDos :todo-entries="todoEntries"
           @toggle-todo-event="changeTodoState"
           @delete-todo-event="deleteToDoItem"
           @edit-todo-event="editToDoItem"
    />
    <AddToDoButton @add-todo-event="addTodoItem"/>
  </div>
</template>

<script>
import ToDos from "./components/ToDos.vue";
import AddToDoButton from "@/components/AddToDoButton.vue";
import todoEntries from "./state";

export default {
  name: "App",
  components: {
    AddToDoButton,
    ToDos,
  },
  methods: {
    addTodoItem(newTodoItem) {
      this.todoEntries.push(newTodoItem);
    },
    changeTodoState(_todo) {
      this.todoEntries
          .filter(todo => todo.id === _todo.id)
          .map(todo=> todo.completed = !todo.completed);
    },
    deleteToDoItem(todoId) {
      this.todoEntries = this.todoEntries.filter(item => item.id !== todoId);
    },
    editToDoItem(todoId) {
      this.todoEntries
          .filter(todo => todo.id === todoId)
          .map(todo => todo.title = "Changed");
    },
  },
  data(){
    return {
      todoEntries
    };
  },
}
</script>

<style>

</style>