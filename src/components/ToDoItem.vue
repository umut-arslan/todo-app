<template>
  <div :class="{'completed' : todoItem.completed}">
    <p @click="$emit('toggle-todo-event', this.todoItem)">{{ todoItem.title }}</p>
    <button @click="$emit('delete-todo-event', todoItem.id)">X</button>
  </div>
</template>

<script>
  export default{
    name: "ToDoItem",
    components: {

    },
    props: [
        "todoItem"
    ]
  }
</script>
<style>
.completed{
  text-decoration: line-through;
}
</style>