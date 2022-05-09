package com.kangmin.meew.view.signup

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentCharacterSelectBinding
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.util.dp
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
            }
            selectedCharacterLiveData.observe(viewLifecycleOwner) {
                binding.btnNext.isEnabled = (it != null)
            }
        }
    }

    override fun setClickEvent() {
        super.setClickEvent()
    }

    private fun initCharacterCard() {

        characterInfoAdapter.setItemListener { character ->
            viewModel.selectedCharacter = character
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