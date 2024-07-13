package dev.leonardom.androidintroduccion.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dev.leonardom.androidintroduccion.R
import dev.leonardom.androidintroduccion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController:NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(navController.graph)

        //BottonNavigationView
        binding.bottomNavigationView?.setupWithNavController(navController)

        //Tollbar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        //NavigationRail
        binding.navigationRailView?.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId)
            {
                R.id.productDetailFragment2 -> {
                    navController.navigate(R.id.productListFragment)
                    true
                }
                R.id.favoritesFragment -> {
                    navController.navigate(R.id.favoritesFragment)
                    true
                }
                R.id.shoppingCartFragment -> {
                    navController.navigate((R.id.shoppingCartFragment))
                    true
                }
                else ->false
            }


        }







    }
}
