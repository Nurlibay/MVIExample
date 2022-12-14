package uz.unidev.mviexample.ui.login

import android.util.Log
import uz.unidev.mviexample.redux.Reducer

/**
 *  Created by Nurlibay Koshkinbaev on 02/09/2022 18:33
 */

/**
 * This reducer is responsible for handling any [LoginAction], and using that to create
 * a new [LoginViewState].
 */

class LoginReducer : Reducer<LoginViewState, LoginAction> {

    /**
     * Side note: Notice the all of the functions are named in a way that they signify they're
     * returning a new state, and not just processing information. This helps keep your when statements
     * clear that they're returning stuff, so that context isn't lost.
     */

    override fun reduce(currentState: LoginViewState, action: LoginAction): LoginViewState {
        Log.v("LoginReducer", "Processing action: $action")

        return when (action) {
            is LoginAction.EmailChanged -> {
                stateWithNewEmail(currentState, action)
            }
            is LoginAction.PasswordChanged -> {
                stateWithNewPassword(currentState, action)
            }
            LoginAction.LoginStarted -> {
                stateAfterLoginStarted(currentState)
            }
            LoginAction.LoginCompleted -> {
                stateAfterLoginCompleted(currentState)
            }
            is LoginAction.LoginFailed -> {
                stateAfterLoginFailed(currentState)
            }
            else -> currentState
        }
    }

    private fun stateAfterLoginStarted(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = true
        )

    private fun stateAfterLoginCompleted(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = false
        )

    private fun stateAfterLoginFailed(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = false
        )

    private fun stateWithNewPassword(
        currentState: LoginViewState,
        action: LoginAction.PasswordChanged
    ) = currentState.copy(
        email = action.password
    )

    private fun stateWithNewEmail(
        currentState: LoginViewState,
        action: LoginAction.EmailChanged
    ) = currentState.copy(
        email = action.newEmail
    )

}