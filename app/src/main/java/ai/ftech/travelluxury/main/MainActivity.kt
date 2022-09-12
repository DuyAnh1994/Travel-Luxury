package ai.ftech.travelluxury.main

import ai.ftech.travelluxury.R
import ai.ftech.travelluxury.main.explore.ExploreFragment
import ai.ftech.travelluxury.main.home.HomeFragment
import ai.ftech.travelluxury.main.myaccount.MyAccountFragment
import ai.ftech.travelluxury.main.mybooking.MyBookingFragment
import ai.ftech.travelluxury.main.saved.SavedFragment
import ai.ftech.travelluxury.message.MessageActivity
import ai.ftech.travelluxury.notification.NotificationActivity
import ai.ftech.travelluxury.search.SearchActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rlSearchBox: RelativeLayout
    private lateinit var ivNotification: RelativeLayout
    private lateinit var ivMessage: RelativeLayout
    private lateinit var flContent: FrameLayout
    private lateinit var bnvNavigator: BottomNavigationView

    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val exploreFragment: ExploreFragment by lazy { ExploreFragment() }
    private val myBookingFragment: MyBookingFragment by lazy { MyBookingFragment() }
    private val savedFragment: SavedFragment by lazy { SavedFragment() }
    private val myAccountFragment: MyAccountFragment by lazy { MyAccountFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initView()
        setOnCLickListener()

        loadFragment(homeFragment)

        setNavigatorListener()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.rlMainSearchBox -> startActivity(Intent(this, SearchActivity::class.java))
            R.id.rlMainNotification -> startActivity(Intent(this, NotificationActivity::class.java))
            R.id.rlMainMessage -> startActivity(Intent(this, MessageActivity::class.java))
        }
    }

    private fun initView() {
        rlSearchBox = findViewById(R.id.rlMainSearchBox)
        ivNotification = findViewById(R.id.rlMainNotification)
        ivMessage = findViewById(R.id.rlMainMessage)
        flContent = findViewById(R.id.flMainContent)
        bnvNavigator = findViewById(R.id.bnvMainNavigator)
    }

    private fun setOnCLickListener() {
        rlSearchBox.setOnClickListener(this)
        ivNotification.setOnClickListener(this)
        ivMessage.setOnClickListener(this)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flMainContent, fragment)
            .commit()
    }

    private fun setNavigatorListener() {
        bnvNavigator.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itmBottomNavigationHome -> {
                    loadFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.itmBottomNavigationExplore -> {
                    loadFragment(exploreFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.itmBottomNavigationMyBooking -> {
                    loadFragment(myBookingFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.itmBottomNavigationSaved -> {
                    loadFragment(savedFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.itmBottomNavigationMyAccount -> {
                    loadFragment(myAccountFragment)
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }

}
