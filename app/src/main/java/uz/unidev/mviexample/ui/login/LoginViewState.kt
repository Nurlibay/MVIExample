package uz.unidev.mviexample.ui.login

import uz.unidev.mviexample.redux.State

/**
 *  Created by Nurlibay Koshkinbaev on 02/09/2022 17:41
 */

/**
 * An implementation of [State] that describes the configuration of the login screen
 * at a given time.
 */

data class LoginViewState(
    val email: String = "",
    val password: String = "",
    val showProgressBar: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null
) : State