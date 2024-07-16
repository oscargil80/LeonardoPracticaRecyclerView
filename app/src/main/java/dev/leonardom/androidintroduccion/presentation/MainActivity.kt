package dev.leonardom.androidintroduccion.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import dev.leonardom.androidintroduccion.R
import dev.leonardom.androidintroduccion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
// navegacion responsive
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.productListFragment,
                R.id.favoritesFragment,
                R.id.shoppingCartFragment,
            ),
            drawerLayout = binding.drawerLayout
        )

        // BottomNavigationView
        binding.bottomNavigationView?.setupWithNavController(navController)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // NavigationRailView
        binding.navigationRailView?.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.productListFragment -> {
                    navController.navigate(R.id.productListFragment)
                    true
                }
                R.id.favoritesFragment -> {
                    navController.navigate(R.id.favoritesFragment)
                    true
                }
                R.id.shoppingCartFragment -> {
                    navController.navigate(R.id.shoppingCartFragment)
                    true
                }
                else -> false
            }
        }

        // DrawerLayout
        binding.navView?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}