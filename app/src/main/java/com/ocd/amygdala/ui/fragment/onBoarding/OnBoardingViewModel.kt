package com.ocd.amygdala.ui.fragment.onBoarding

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.ocd.amygdala.data.SlideContent
import com.ocd.amygdala.app.R

class OnBoardingViewModel(application: Application) : AndroidViewModel(application) {
    private val list = listOf(
        SlideContent(


            ContextCompat.getDrawable(application.applicationContext, R.drawable.screen_1)!!,
            "",
            ""
        ),
        SlideContent(
            ContextCompat.getDrawable(application.applicationContext, R.drawable.screen_2)!!,
            "",
            ""
        ),
        SlideContent(
            ContextCompat.getDrawable(application.applicationContext, R.drawable.screen_3)!!,
            "",
            ""
        ),
        SlideContent(
            ContextCompat.getDrawable(application.applicationContext, R.drawable.screen_4)!!,
            "",
            ""
        )
    )

    private val _dataSet = MutableLiveData<List<SlideContent>>().apply { value = list }
    val dataSet: LiveData<List<SlideContent>>
        get() = _dataSet

    private val _buttonVisiability = MutableLiveData<Boolean>().apply { value = false }
    val buttonVisiability: LiveData<Boolean>
        get() = _buttonVisiability

    val pagerCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            _buttonVisiability.value = position == list.size - 1
            super.onPageSelected(position)
        }
    }
    private val _startNavigation = MutableLiveData<Boolean>().apply { value = false }
    val startNavigation: LiveData<Boolean>
        get() = _startNavigation

    fun navigateToAuth() {
        _startNavigation.value = true
    }

    fun doneNavigation() {
        _startNavigation.value = false
    }
}