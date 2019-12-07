package com.example.orientator2000.ui.students_path

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orientator2000.R
import com.example.orientator2000.User
import com.example.orientator2000.ui.NetworkService
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    // Initializing an empty ArrayList to be filled with animals
    val users: ArrayList<User> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_paths, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        recyclerView = root.findViewById<RecyclerView>(R.id.students_list).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = LinearLayoutManager(root.context)

            // specify an viewAdapter (see also next example)
            adapter = UserAdapter(users,root.context)
        }

        addUsers()

        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    fun addUsers() {
        for (i in 1..5) {
            users.add(User(ap = "Отличник", city = "Воронеж", desires = "null", type = "null"))
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    /*
    inner class UserLoginTask internal constructor(private val mEmail: String, private val mPassword: String) :
        Callback<User>,
        AsyncTask<Void, Void, Boolean>() {
        override fun onFailure(call: Call<User>, t: Throwable) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            System.out.println(t.message)
        }

        override fun onResponse(call: Call<User>, response: Response<User>) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            if (response.isSuccessful){
                System.out.println(response.body()?.pass)
            } else {
                System.out.println(response.errorBody())
            }
        }

        override fun doInBackground(vararg params: Void): Boolean? {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                //Thread.sleep(2000)
                val userAPI = NetworkService.createUserAPI()
                val call = userAPI.search(User(mEmail,mPassword))
                call.enqueue(this)
            } catch (e: InterruptedException) {
                return false
            }

            return null
        }

        override fun onPostExecute(success: Boolean?) {
            mAuthTask = null
            showProgress(false)

            if (success!!) {
                finish()
            } else {
                ap.error = getString(R.string.error_incorrect_password)
                ap.requestFocus()
            }
        }

        override fun onCancelled() {
            mAuthTask = null
            showProgress(false)
        }
    }*/
}
