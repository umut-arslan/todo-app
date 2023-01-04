<template>
  <div id="app" class="flex flex-col p-5 w-fit m-auto pt-8">
    <h1 class="m-auto font-bold text-4xl my-10 tracking-widest">FANCY TODO APP</h1>
    <div class=" shadow-2xl rounded-2xl p-7 max-w-[50vw]">
      <h3 class="font-medium m-auto text-xl">MY TASKS:</h3>
      <ToDos :todo-entries="todoEntries"
             @toggle-todo-event="changeTodoState"
             @delete-todo-event="deleteToDoItem"
             @edit-todo-event="editToDoItem"
             class="m-auto"
      />
      <div class="m-auto mt-10">
        <AddToDoButton
            v-if="this.toEdit==null"
            @add-todo-event="addTodoItem"
            class=""
        />
        <EditToDoButton
            v-else
            :entries="todoEntries"
            :id="toEdit"
            @editToDoEvent="editToDoEvent"
            class=""
        />
      </div>
    </div>
  </div>
</template>

<script>
import ToDos from "./components/ToDos.vue";
import AddToDoButton from "@/components/form/AddToDoButton.vue";
import todoEntries from "./state";
import EditToDoButton from "@/components/form/EditToDoButton";

export default {
  name: "App",
  components: {
    EditToDoButton,
    AddToDoButton,
    ToDos,
  },
  methods: {
    async getTodos() {
      const res = await fetch("http://localhost:3000/todos");
      const data = await res.json();
      this.todoEntries = data;
    },
    addTodoItem(newTodoItem) {
      this.todoEntries.push(newTodoItem);
    },
    changeTodoState(_todo) {
      this.todoEntries
          .filter(todo => todo.id === _todo.id)
          .map(todo => todo.completed = !todo.completed);
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
          .map(todo => todo.title = editedTitle);
      this.toEdit = null;
    },
  },
  mounted() {
    this.getTodos();
  },
  data() {
    return {
      toEdit: null,
      todoEntries
    };
  },
}
</script>