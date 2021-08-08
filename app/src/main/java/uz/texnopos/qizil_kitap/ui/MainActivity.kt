package uz.texnopos.qizil_kitap.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import uz.texnopos.qizil_kitap.R
import uz.texnopos.qizil_kitap.databinding.ActivityMainBinding
import uz.texnopos.qizil_kitap.ui.nature.NatureFragment

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(this,drawerLayout,binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener {
           when(it.itemId){
           R.id.nav_home ->{
               return@setNavigationItemSelectedListener true
           }
           R.id.nav_gallery ->{
               return@setNavigationItemSelectedListener true
           }
           R.id.nav_slideshow ->{
           return@setNavigationItemSelectedListener true
           }
               else ->{return@setNavigationItemSelectedListener  false}
           }
        }
        supportFragmentManager.beginTransaction().replace(R.id.FrameLayoutContainer,NatureFragment()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


}