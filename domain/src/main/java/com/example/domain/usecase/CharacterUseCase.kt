package com.example.domain.usecase

import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterUseCase @Inject constructor(
    private val characterRepo: CharacterRepository
) {
    /** 오늘의 캐릭터 전달 */
    fun getTodayCharacter() = flow {
        kotlin.runCatching {
            characterRepo.getTodayTodo()
        }.onSuccess {
            emit(it)
        }
    }

    /** 투두 아이템 체크 전달 */
    fun checkTodoResponseFlow(taskId: Int) = flow {
        kotlin.runCatching {
            characterRepo.checkTodo(taskId)
        }.onSuccess {
            emit(it)
        }
    }
}