package com.example.demo

import ToDo
import ToDoItem
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

val toDo = ToDo()

@Api("ToDo API")
@RestController
class DemoController {

    @GetMapping("/home")
    fun home(): String = "HOME"

    @ApiOperation("Получить список задач")
    @GetMapping("/tasks")
    fun listOutPut(): ResponseEntity<Any> {
        return ResponseEntity.ok(toDo.listOutPut())
    }

    @ApiOperation("Добавить задачу")
    @PostMapping("/tasks")
    fun addItem(@RequestBody request: Task): ResponseEntity<Any> {
        val status = Status.ACTIVE
        val date = LocalDate.now()

        val item = ToDoItem(request.desc, status, date, request.dopInfo)
        toDo.addItem(item)

        return ResponseEntity.ok(item)
    }

    @ApiOperation("Получить задачу по описанию")
    @GetMapping("/tasks/{desc}")
    fun getDesc(@RequestBody request: Desc): ResponseEntity<Any> {
        val foundItem = toDo.getDesc(request.desc)
        if (foundItem != null) {
            return ResponseEntity.ok(foundItem)
        } else return ResponseEntity.notFound().build()
    }

    @ApiOperation("Удалить задачу")
    @DeleteMapping("/tasks/{id}")
    fun deleteId(@RequestBody request: Id): ResponseEntity<Any> {
        val itemId = request.id.toIntOrNull() ?: -1
        if (itemId != -1) {
            if (toDo.deleteId(itemId)) {
                return ResponseEntity.ok().build()
            } else return ResponseEntity.notFound().build()
        } else return ResponseEntity.badRequest().body("Неверный id")
    }

    @ApiOperation("Удалить список задач")
    @DeleteMapping("/tasks")
    fun deleteAll(): ResponseEntity<Any> {
        return ResponseEntity.ok(toDo.deleteAll())
    }

    @ApiOperation("Обновить задачу")
    @PutMapping("/tasks/{itemId}")
    fun updateItem(@RequestBody request: Subtask, @PathVariable itemId: Int): ResponseEntity<Any> {
        //val itemId = request.id.toIntOrNull() ?: -1
        if (itemId != -1) {
            val item = toDo.getId(itemId)
            if (item != null) {
                val newStatus = Status.ACTIVE
                val newDate = LocalDate.now()

                toDo.updateItem(itemId, request.desc, newStatus, newDate, request.dopInfo)
                return ResponseEntity.ok(item)
            } else return ResponseEntity.notFound().build()
        }else return ResponseEntity.badRequest().body("Неверный id")
    }

    @ApiOperation("Добавить подзадачу")
    @PostMapping("/tasks/{id}")
    fun addSub(@RequestBody request: Subtask): ResponseEntity<Any> {
        val itemId = request.id.toIntOrNull() ?: -1
        if (itemId != -1) {
            val item = toDo.getId(itemId)
            if (item != null) {
                val status = Status.ACTIVE
                val date = LocalDate.now()

                val sub = ToDoItem(request.desc, status, date, request.dopInfo)
                item.addSub(sub)
                return ResponseEntity.ok(item)
            } else return ResponseEntity.notFound().build()
        }else return ResponseEntity.badRequest().body("Неверный id")
    }
}



data class Task(
    val desc: String,
    val status: String,
    val date: String,
    val dopInfo: String
)

data class Subtask(
    val id: String,
    val desc: String,
    val status: String,
    val date: String,
    val dopInfo: String
)

data class Id(
    val id: String
)

data class Desc(
    val desc: String
)

