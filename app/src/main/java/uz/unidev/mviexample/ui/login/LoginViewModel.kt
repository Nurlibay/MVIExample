package uz.unidev.mviexample.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import uz.unidev.mviexample.redux.Store

/**
 *  Created by Nurlibay Koshkinbaev on 02/09/2022 17:01
 */

/**
 * The [LoginViewModel] is responsible for controlling the UI logic of the login screen. It will
 * listen for text changes and button clicks, and update the UI state according and expose that so
 * the View can update.
 */

/**
 * Whenever a view action occurs , such as [emailChanged] or [signInButtonClicked], proxy the
 * corresponding [LoginAction] to our [store]
 */

class LoginViewModel: ViewModel() {
    private val store = Store(
        initialState = LoginViewState(),
        reducer = LoginReducer()
    )

    val viewState: StateFlow<LoginViewState> = store.state

    fun emailChanged(newEmail: String){
        val action = LoginAction.EmailChanged(newEmail)
        store.dispatch(action)
    }

    fun passwordChanged(newPassword: String){
        val action = LoginAction.PasswordChanged(newPassword)
        store.dispatch(action)
    }

    fun signInButtonClicked(){
        val action = LoginAction.SignInButtonClicked
        store.dispatch(action)
    }
}