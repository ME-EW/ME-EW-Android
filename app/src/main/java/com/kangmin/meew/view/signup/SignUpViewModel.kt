package com.kangmin.meew.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.domain.model.CharacterInfo
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.util.ListLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : BaseViewModel() {

    private val _characters = ListLiveData<CharacterInfo>()
    val characters: LiveData<List<CharacterInfo>> = _characters.map { it }

    
}