package com.kangmin.meew.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.domain.model.CharacterInfo
import com.example.domain.usecase.SignUpUseCase
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.util.ListLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : BaseViewModel() {

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
        _characters.value = signUpUseCase.getCharacters().toMutableList()
    }

}