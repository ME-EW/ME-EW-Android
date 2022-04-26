package com.kangmin.meew.view.signup

import androidx.fragment.app.activityViewModels
import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentCharacterSelectBinding
import com.kangmin.meew.view.signup.adapter.CharacterViewPagerAdapter

class CharacterSelectFragment : BaseFragment<FragmentCharacterSelectBinding>(R.layout.fragment_character_select) {

    private val viewModel by activityViewModels<SignUpViewModel>()

    private val characterInfoAdapter by lazy {
        CharacterViewPagerAdapter()
    }

    override fun setOnCreateView() {
        initCharacterCard()
    }

    override fun setOnViewCreated() {
    }

    override fun setObserve() {
        super.setObserve()

        viewModel.run {
            characters.observe(viewLifecycleOwner) {
                characterInfoAdapter.characterInfoDiffUtil.set(it.toMutableList())
            }
        }
    }

    override fun setClickEvent() {
        super.setClickEvent()
    }

    private fun initCharacterCard() {
        binding.viewpagerCharacter.adapter = characterInfoAdapter
        binding.dotIndicator.setViewPager2(binding.viewpagerCharacter)
    }
}