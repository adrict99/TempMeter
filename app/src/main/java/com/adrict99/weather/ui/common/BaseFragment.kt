package com.adrict99.weather.ui.common

import android.app.Dialog
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.adrict99.weather.data.preferences.SharedPrefs
import com.adrict99.weather.util.DialogUtils
import com.adrict99.weather.util.ViewModelFactory
import com.adrict99.weather.util.navigation.Navigator
import com.adrict99.weather.util.showCustomMessage
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<V: ViewBinding>(contentLayoutId: Int) : Fragment(contentLayoutId) {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    private val progressDialog: Dialog by lazy { DialogUtils().getLoadingDialog(requireActivity()) }

    lateinit var binding: V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onStop() {
        super.onStop()
        if (progressDialog.isShowing) progressDialog.dismiss()
    }

    fun manageLoadingDialog(mustShow: Boolean) {
        if (mustShow)
            progressDialog.show()
        else
            progressDialog.dismiss()
    }

    fun handleError(it: Map<Int, String>) {
        requireActivity().showCustomMessage(it.values.first(), Snackbar.LENGTH_LONG)
        when (it.keys.first()) {
            401 -> logout()
        }
    }

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@BaseFragment, this).get(T::class.java)

    fun logout() {
        //Handle auth token not valid network response
    }
}