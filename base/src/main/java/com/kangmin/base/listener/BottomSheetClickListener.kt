package com.kangmin.base.listener

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BottomSheetClickListener {
    fun setClickOk(bottomSheet: BottomSheetDialogFragment)
    fun setClickCancel(bottomSheet: BottomSheetDialogFragment)
}