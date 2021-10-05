package com.rsdev.bottomsheetapp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rsdev.bottomsheetapp.databinding.BottomSheetBinding

class ModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var bottomSheetBinding: BottomSheetBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetBinding.bottomSheetFrame)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.peekHeight = 3000
        bottomSheetBehavior.isFitToContents = true
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            bottomSheetBinding.handleStates.text = when (newState) {
                else -> newState.toString()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        bottomSheetBinding = BottomSheetBinding.inflate(inflater, container, false)
        return bottomSheetBinding.root
    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}