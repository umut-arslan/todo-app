<template>
  <div>
    <ul>
      <li :key="item.id"  v-for="item in todoEntries">
        <ToDoItem :todo-item="item"
                  @toggle-todo-event="$emit('toggle-todo-event', item)"
                  @delete-todo-event="$emit('delete-todo-event', item.id)"
                  @edit-todo-event="$emit('edit-todo-event', item.id)"
        />
      </li>
    </ul>
  </div>
</template>
<script>
  import ToDoItem from "@/components/ToDoItem.vue";
  export default{
    name: "ToDos",
    components: {
      ToDoItem,
    },
    props:[
      "todoEntries"
    ]
  }
</script>