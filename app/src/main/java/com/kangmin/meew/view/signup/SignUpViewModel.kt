package com.kangmin.meew.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CharacterInfo
import com.example.domain.usecase.SignUpUseCase
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.util.FlowApi
import com.kangmin.meew.util.ListLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : BaseViewModel() {

    /** 카카오 AccessToken */
    var kakaoToken: String = ""

    private val _characters = ListLiveData<CharacterInfo>()
    val characters: LiveData<List<CharacterInfo>> = _characters.map { it }

    /** 선택한 캐릭터 정보 */
    private val _selectedCharacter = MutableLiveData<CharacterInfo>()
    val selectedCharacterLiveData: LiveData<CharacterInfo> = _selectedCharacter
    var selectedCharacter: CharacterInfo? = null
        set(value) {
            value?.let {
                _selectedCharacter.value = it
            }
            field = value
        }

    /** 닉네임 */
    val nickName = MutableLiveData("")
    val nickNameLengthText: LiveData<String> = nickName.map {
        return@map "${it.length}/10"
    }

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
//            FlowApi{ signUpUseCase.getCharactersFlow() }
//                .onSuccess {
//                    Dlog.i("check characterList")
//                    _characters.postValue(it.toMutableList())
//                }.onHttpException {
//                    _toastMsg.postValue("캐릭터 목록을 불러오는데 실패했습니다.err:$it")
//                }.onEtcException {
//                    _toastMsg.postValue("서버 문제로 인해 캐릭터 목록을 불러오는데 실패했습니다.")
//                }.build()

            signUpUseCase.getCharactersFlow().collectLatest {
                _characters.postValue(it.toMutableList())
            }
        }
    }
}