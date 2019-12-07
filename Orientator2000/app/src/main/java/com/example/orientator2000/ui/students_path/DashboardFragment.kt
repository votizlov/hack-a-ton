package com.example.orientator2000.ui.students_path

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.orientator2000.R
import kotlinx.android.synthetic.main.activity_login.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_paths, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    inner class UserLoginTask internal constructor(private val mEmail: String, private val mPassword: String) :Callback<User>,
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
    }
}
