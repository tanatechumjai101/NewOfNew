package com.example.thefirstnewprojectaddtoday28jan62.main.person


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.thefirstnewprojectaddtoday28jan62.R
import com.example.thefirstnewprojectaddtoday28jan62.login.LoginActivity
import com.example.thefirstnewprojectaddtoday28jan62.util.Singleton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_person.*
import java.text.SimpleDateFormat
import java.util.*


class PagePersonFragment : Fragment() {

    private lateinit var mActivity: Activity
    private var googleSignIn: GoogleSignInClient? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mActivity = activity!!
        val view = inflater.inflate(R.layout.fragment_person, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dateTime = SimpleDateFormat("dd-MMM-yyyy-HH:mm:ss").format(Date())
        tv_last_login_profile.setText("$dateTime")
        display_profile.text = Singleton.displayName
        email_profile.text = Singleton.email
        if (Singleton.imageUrl!!.isEmpty()) {
//            Load any image
            img_profile!!.setImageResource(R.drawable.ic_person24dp)
        } else {
//            Load profile image
            Glide.with(mActivity).load(Singleton.imageUrl)
                .into(img_profile)
        }
        initGoogleLogin()
        sign_out_profile.setOnClickListener {
            googleSignIn?.signOut()
            val intent = Intent(mActivity, LoginActivity::class.java)
            startActivity(intent)
            mActivity.finishAffinity()
        }
    }

    private fun initGoogleLogin() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignIn = GoogleSignIn.getClient(mActivity, googleSignInOptions)
    }

    companion object {
        fun newInstance() = PagePersonFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}