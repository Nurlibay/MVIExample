package uz.unidev.mviexample.ui.login

import uz.unidev.mviexample.redux.Action

/**
 *  Created by Nurlibay Koshkinbaev on 02/09/2022 17:46
 */

/**
 * These are all of the possible actions that triggered from the login screen
 */

sealed class LoginAction : Action {
    data class EmailChanged(val newEmail: String) : LoginAction()
    data class PasswordChanged(val password: String) : LoginAction()
    object SignInButtonClicked : LoginAction()
    object LoginStarted : LoginAction()
    object LoginCompleted : LoginAction()
    data class LoginFailed(val error: Throwable?) : LoginAction()
}