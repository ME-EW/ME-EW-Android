package com.kangmin.meew.view.signup

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentCharacterSelectBinding
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.util.dp
import com.kangmin.meew.view.signup.adapter.CharacterViewPagerAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharacterSelectFragment :
    BaseFragment<FragmentCharacterSelectBinding>(R.layout.fragment_character_select) {

    private val viewModel by activityViewModels<SignUpViewModel>()

    private val characterInfoAdapter by lazy {
        CharacterViewPagerAdapter()
    }

    override fun setOnCreateView() {}

    override fun setOnViewCreated() {
        binding.run {
            fragment = this@CharacterSelectFragment
            viewModel = viewModel
        }
    }

    override fun setObserve() {
        super.setObserve()

        viewModel.run {
            characters.observe(viewLifecycleOwner) {
                characterInfoAdapter.characterInfoDiffUtil.set(it.toMutableList())
                initCharacterCard()
            }
        }
    }

    private fun initCharacterCard() {

        characterInfoAdapter.setItemListener { character ->
            viewModel.selectedCharacter = character
            binding.btnNext.isEnabled = true
        }

        binding.viewpagerCharacter.run {
            offscreenPageLimit = 2
            val offsetPx = 30.dp // 좌우 아이템이 보여지는 정도
            val marginPx = 10.dp // 현재 아이템과 좌우 아이템의 간격
            setPadding(offsetPx, 0, offsetPx, 0)
            setPageTransformer(MarginPageTransformer(marginPx))
            adapter = characterInfoAdapter
        }
        binding.dotIndicator.setViewPager2(binding.viewpagerCharacter)

    }

    fun moveNickNameStep() {
        findNavController().navigate(R.id.action_characterSelectFragment_to_nickNameFragment)
    }
}