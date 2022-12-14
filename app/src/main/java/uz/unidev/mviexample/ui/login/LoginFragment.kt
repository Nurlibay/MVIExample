package uz.unidev.mviexample.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import uz.unidev.mviexample.R
import uz.unidev.mviexample.databinding.FragmentLoginBinding

/**
 *  Created by Nurlibay Koshkinbaev on 02/09/2022 17:01
 */

class LoginFragment: Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        /**
         * Whenever the view is resumed, subscribe to our viewModel's view state StateFlow
         * */
        lifecycleScope.launchWhenResumed {
            viewModel.viewState.collect { viewState ->
                processViewState(viewState)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Whenever a relevant UI action occurs like a text change or a button click, proxy that
     * to the view model to handle.
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.emailInput.doOnTextChanged { text, _, _, _ ->
            viewModel.emailChanged(text?.toString().orEmpty())
        }

        binding.passwordInput.doOnTextChanged { text, _, _, _ ->
            viewModel.passwordChanged(text?.toString().orEmpty())
        }

        binding.signInButton.setOnClickListener {
            viewModel.signInButtonClicked()
        }
    }

    private fun processViewState(viewState: LoginViewState){
        binding.progressBar.visibility = if(viewState.showProgressBar){
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}