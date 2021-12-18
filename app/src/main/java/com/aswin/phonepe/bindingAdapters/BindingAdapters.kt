package com.aswin.phonepe.bindingAdapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aswin.phonepe.utils.setImage

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun setImage(view: ImageView, imgUrl: String?) {
        view.setImage(imgUrl)
    }

    @JvmStatic
    @BindingAdapter("viewVisibility")
    fun viewVisibility(view: View, show: Boolean) {
        if (show) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}