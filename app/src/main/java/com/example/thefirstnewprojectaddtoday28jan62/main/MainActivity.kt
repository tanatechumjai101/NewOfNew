package com.example.thefirstnewprojectaddtoday28jan62.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.thefirstnewprojectaddtoday28jan62.*
import com.example.thefirstnewprojectaddtoday28jan62.base.BaseActivity
import com.example.thefirstnewprojectaddtoday28jan62.main.owner.PageOwnerFragment
import com.example.thefirstnewprojectaddtoday28jan62.main.home.PageMainFragment
import com.example.thefirstnewprojectaddtoday28jan62.main.person.PagePersonFragment
import com.example.thefirstnewprojectaddtoday28jan62.main.setting.PageSettingFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*


class MainActivity : BaseActivity() {

    private lateinit var pagemainFragment: PageMainFragment
    private lateinit var pagechatFragment: PageOwnerFragment
    private lateinit var pagepersonFragment: PagePersonFragment
    private lateinit var pagesettingFragment: PageSettingFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pagemainFragment = PageMainFragment.newInstance()
        pagechatFragment = PageOwnerFragment.newInstance()
        pagepersonFragment = PagePersonFragment.newInstance()
        pagesettingFragment = PageSettingFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameNav, pagemainFragment)
            .commit()

        NavMain.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameNav, pagemainFragment)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.person -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameNav, pagepersonFragment)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.chat -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameNav, pagechatFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        true
    }
}

