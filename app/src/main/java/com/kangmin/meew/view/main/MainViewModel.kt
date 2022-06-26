package com.kangmin.meew.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.domain.model.TodayTodo
import com.example.domain.model.Todo
import com.example.domain.usecase.CharacterUseCase
import com.kangmin.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : BaseViewModel() {

    private val _todayTodoInfo = MutableLiveData<TodayTodo>()
    val todayTodoInfo: LiveData<TodayTodo> = _todayTodoInfo

    val todoInfo: LiveData<List<Todo>> = _todayTodoInfo.map { it.todo }

    val nickNameLiveData: LiveData<String> = _todayTodoInfo.map { "오늘의 ${it.nickname}님" }
    val characterLevelLiveData: LiveData<String> = _todayTodoInfo.map { "Lv. ${it.level}" }
    val refreshCountLiveData: LiveData<String> = _todayTodoInfo.map { "${it.refreshCount}/3" }

    init {
        callTodayCharacter()
    }

    private fun callTodayCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            characterUseCase.getTodayCharacter().catch {
                if (it is HttpException) {
                    _toastMsg.postValue(it.code().toString())
                } else {
                    _toastMsg.postValue("서버 문제로 인한 캐릭터 불러오기 실패")
                }
            }.collect {
                _todayTodoInfo.postValue(it)
            }
        }
    }

}