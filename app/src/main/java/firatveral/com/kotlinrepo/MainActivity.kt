package firatveral.com.kotlinrepo

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import firatveral.com.kotlinrepo.adapter.CommitAdapter
import firatveral.com.kotlinrepo.adapter.RestApiBuilder
import firatveral.com.kotlinrepo.model.KotlinList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: CommitAdapter? = null
    private var coordinatorLayout: CoordinatorLayout? = null

    private val isNetworkAvailable: Boolean
        get() {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(android.view.View.OnClickListener {
            Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        })

        coordinatorLayout = findViewById(R.id.coordinator_layout) as CoordinatorLayout
        recyclerView = findViewById(R.id.recycler_user_list) as RecyclerView
        val layoutManager = GridLayoutManager(getApplicationContext(), 1)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setLayoutManager(layoutManager)


        //TODO: checking for network connectivity
        if (!isNetworkAvailable) {
            val snackbar = Snackbar
                .make(coordinatorLayout!!, "No Network connection", Snackbar.LENGTH_LONG)
                .setAction("RETRY", object : View.OnClickListener {
                    public override fun onClick(view: View) {

                        fetchUsersData()
                    }
                })

            snackbar.show()
        } else {
            fetchUsersData()
        }


    }


    private fun prepareData(commitList: KotlinList) {
        adapter = commitList.items?.let { CommitAdapter(it) }
        recyclerView!!.setAdapter(adapter)
        recyclerView!!.addItemDecoration(
            DividerItemDecoration(
                recyclerView!!.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )

    }


    private fun fetchUsersData() {
        val searchParams = "repo:JetBrains/kotlin kotlin"
        val apiService = RestApiBuilder().service
        val userListCall = apiService.getUserList(
            "application/json",
            "application/vnd.github.cloak-preview",
            searchParams
        )
        userListCall.enqueue(object : Callback<KotlinList> {
            override fun onResponse(call: Call<KotlinList>, response: Response<KotlinList>) {
                if (response.isSuccessful()) {
                    val userList = response.body()
                    prepareData(userList)
                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Request not Sucessful",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<KotlinList>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Request failed. Check your internet connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

}
