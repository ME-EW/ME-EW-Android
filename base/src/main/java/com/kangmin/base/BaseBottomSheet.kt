package com.kangmin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kangmin.base.listener.BottomSheetClickListener

abstract class BaseBottomSheet<T : ViewBinding>(
    val bindingFactory: (LayoutInflater, ViewGroup?) -> T,
    private val cancelable: Boolean = false
) : BottomSheetDialogFragment() {
    protected lateinit var binding: T
    private var clickListener: BottomSheetClickListener? = null

    fun setBottomSheetClickListener(l: BottomSheetClickListener) {
        clickListener = l
    }

    open fun setBottomSheetView() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isCancelable = cancelable
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindingFactory(inflater, container)
        setBottomSheetView()
        return binding.root
    }
}
