package com.example.data.impl

import com.example.data.service.CharacterService
import com.example.domain.model.CharacterInfo
import com.example.domain.model.TodayTodo
import com.example.domain.model.Todo
import com.example.domain.repository.CharacterRepository
import com.example.domain.util.getCharacter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterInfo> {
        val callbackResult = characterService.getCharacters()
        val result = mutableListOf<CharacterInfo>()

        callbackResult.data.forEachIndexed { index, character ->
            result.add(
                CharacterInfo(
                    image = character.imageUrl,
                    characterName = character.name,
                    characterInfo = character.description,
                    characterSelected = false,
                    characterEnum = (index + 1).getCharacter()
                )
            )
        }

        return result
    }

    override suspend fun getTodayTodo(): TodayTodo {
        val callbackResult = characterService.getTodayCharacter().data
        val todoList = mutableListOf<Todo>()

        return callbackResult.run {
            val result = TodayTodo(
                nickname = nickname,
                characterName = characterName,
                level = characterLevel,
                characterImage = characterImage,
                refreshCount = refreshCount,
                finished = finished,
                todo = listOf()
            )
            todo.forEach {
                todoList.add(
                    Todo(
                        id = it.taskId,
                        content = it.content,
                        complete = it.complete
                    )
                )
            }
            result.todo = todoList

            result
        }
    }

    override suspend fun checkTodo(taskId: Int): TodayTodo {
        val callbackResult = characterService.checkTodo(taskId).data
        val todoList = mutableListOf<Todo>()

        return callbackResult.run {
            val result = TodayTodo(
                nickname = nickname,
                characterName = characterName,
                level = characterLevel,
                characterImage = characterImage,
                refreshCount = refreshCount,
                finished = finished,
                todo = listOf()
            )

            todo.forEach {
                todoList.add(
                    Todo(
                        id = it.taskId,
                        content = it.content,
                        complete = it.complete
                    )
                )
            }
            result.todo = todoList

            result
        }
    }
}