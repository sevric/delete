package com.example.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.delete.databinding.FragmentViewPagerBinding

private const val NUM_PAGES = 3

class ViewPagerFragment : Fragment() {
    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentViewPagerBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.viewPager2.adapter = pagerAdapter
        binding.viewPager2.setPageTransformer(DepthPageTransformer())
    }

//    override fun onBackPressed() {
//        if (viewPager.currentItem == 0) {
//            super.onBackPressed()
//        } else {
//            viewPager.currentItem = viewPager.currentItem - 1
//        }
//    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = ViewPagerItemFragment()
    }
}