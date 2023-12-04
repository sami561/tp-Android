package com.example.tplogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tplogin.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var user: FirebaseUser
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var actionToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        initmenu(binding)
        initnav(navView)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!
        if (user == null) {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        } else {
            binding.tvDetails.text = user!!.email.toString()
        }
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initnav(navView: NavigationView) {

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.users -> {
                    val intent = Intent(this, ListUsers::class.java)
                    startActivity(intent)

                    Toast.makeText(this,"hellooooo", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.profile -> {
                    true
                }

                else->  {
                    false
                }
            }
        }

    }

    private fun initmenu(binding: ActivityMainBinding) {
        drawerLayout = binding.drawer
        navView = binding.nav

        //setSupportActionBar(binding.toolbar)
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        actionToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbar, 0, 0)
        drawerLayout.addDrawerListener(actionToggle)
        actionToggle.syncState()

    }
}