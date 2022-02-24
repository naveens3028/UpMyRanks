package com.wasimsirschaudharyco.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wasimsirschaudharyco.fragment.*
import com.wasimsirschaudharyco.fragment.practiceTest.TestFragment
import com.wasimsirschaudharyco.model.onBoarding.LoginData


/**
 * Created by Prabhu2757 on 19-06-2016.
 */
class HomeTabViewAdapter(fm: FragmentActivity, val loginResponse: LoginData) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return if (loginResponse.role.equals("COACH")) {
            2
        } else {
            2
        }
    }

    override fun createFragment(position: Int): Fragment {
        if (loginResponse.role.equals("COACH")) {
            return when (position) {
                0 -> {
                    PublishedMaterialsFragment.newInstance("", "")
                }
/*
                1 -> {
             */
/*       PublishedMaterialsFragment.newInstance("", "")
                }
                2 -> {*//*

                    TestFragment.newInstance("", "")
                }
*/
                else -> {
                    AssignmentFragment.newInstance("", "")
                }
            }
        }else{
            return when (position) {
                0 -> {
                    LearnFragment()
                }
                /* 1 -> {
                     TestFragment.newInstance("", "")
                 }*/
                else -> {
                    AssignmentFragment.newInstance("", "")
                }
            }

        }
    }
}
