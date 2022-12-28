<template>
  <div id="app">
    <p class="bg-amber-500">trest</p>
    <ToDos :todo-entries="todoEntries"
           @toggle-todo-event="changeTodoState"
           @delete-todo-event="deleteToDoItem"
           @edit-todo-event="editToDoItem"
    />
    <AddToDoButton
        v-if="this.toEdit==null"
        @add-todo-event="addTodoItem"
    />
    <EditToDoButton
      v-else
      :entries="todoEntries"
      :id="toEdit"
      @editToDoEvent="editToDoEvent"
    />
  </div>
</template>

<script>
import ToDos from "./components/ToDos.vue";
import AddToDoButton from "@/components/AddToDoButton.vue";
import todoEntries from "./state";
import EditToDoButton from "@/components/EditToDoButton";

export default {
  name: "App",
  components: {
    EditToDoButton,
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
    editToDoItem(todoID) {
      this.toEdit = todoID;
    },
    editToDoEvent(editedTitle) {
      this.todoEntries
          .filter(todo => todo.id === this.toEdit)
          .map(todo=> todo.title = editedTitle);
      this.toEdit = null;
    },
  },
  data(){
    return {
      toEdit: null,
      todoEntries
    };
  },
}
</script>

<style>

</style>