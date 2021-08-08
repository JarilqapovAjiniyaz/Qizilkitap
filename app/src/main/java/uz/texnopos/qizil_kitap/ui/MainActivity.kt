package uz.texnopos.qizil_kitap.ui

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import uz.texnopos.qizil_kitap.R
import uz.texnopos.qizil_kitap.databinding.ActivityMainBinding
import uz.texnopos.qizil_kitap.ui.nature.NatureFragment

class MainActivity : AppCompatActivity() {
    companion object{
        const val TYPE_ID = "typeId"
        const val INVERTEBRATES = 1
        const val FISHES = 2
        const val REPTILES = 3
        const val BIRDS = 4
        const val MAMMALS = 5
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(this,drawerLayout,binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        val fragment = NatureFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, INVERTEBRATES)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.FrameLayoutContainer,fragment).commit()
        navView.setNavigationItemSelectedListener {
            val mFragment = NatureFragment()
            val mBundle =  Bundle()
           when(it.itemId){

           R.id.nav_invertebrates ->{
               mBundle.putInt(TYPE_ID, INVERTEBRATES)
               mFragment.arguments = mBundle

           }
           R.id.nav_fishes ->{
               mBundle.putInt(TYPE_ID, FISHES)
               mFragment.arguments = mBundle

           }
           R.id.nav_reptiles ->{
               mBundle.putInt(TYPE_ID, REPTILES)
               mFragment.arguments = mBundle

           }
               R.id.nav_birds ->{
                   mBundle.putInt(TYPE_ID, BIRDS)
                   mFragment.arguments = mBundle

               }
               R.id.nav_mammals ->{
                   mBundle.putInt(TYPE_ID, MAMMALS)
                   mFragment.arguments = mBundle

               }
               else ->{return@setNavigationItemSelectedListener  false}
           }
            supportFragmentManager.beginTransaction().replace(R.id.FrameLayoutContainer,mFragment).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


}