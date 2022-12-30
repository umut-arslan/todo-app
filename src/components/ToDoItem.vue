<template>
  <div :class="{'completed' : todoItem.completed}" class="flex flex-row my-5 justify-between">
    <span @click="$emit('toggle-todo-event', this.todoItem)"
       class="mx-5 text-xl text-white p-2 bg-blue-500 rounded-2xl max-w-[70%]"
    >{{ todoItem.title }}</span>
    <div>
      <button @click="$emit('edit-todo-event', todoItem.id)"
              class="mx-1"
      >E</button>
      <button @click="$emit('delete-todo-event', todoItem.id)"
              class=""
      >X</button>
    </div>
  </div>
</template>

<script>
  export default{
    name: "ToDoItem",
    props: [
        "todoItem"
    ]
  }
</script>
<style lang="scss">
.completed{
  text-decoration: line-through;
  color: white;
}

</style>