package com.demo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.demo.navigation.ui.screen.Registration
import com.demo.navigation.ui.screen.RegistrationDetail
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf


@Serializable
sealed class Routes {

    @Serializable
    data object RegistrationScreen : Routes()

    @Serializable
    data class RegistrationDetailScreen(val registrationInfo: RegistrationInfo) : Routes()

}

fun NavGraphBuilder.navGraph(navController: NavController) {

    composable<Routes.RegistrationScreen> {
        Registration { info ->
            navController.navigate(Routes.RegistrationDetailScreen(registrationInfo = info))
        }
    }

    composable<Routes.RegistrationDetailScreen>(
        typeMap = mapOf(
            typeOf<RegistrationInfo>() to CustomNavType(
                RegistrationInfo::class.java,
                RegistrationInfo.serializer()
            )
        )
    )
    { navBackStackEntry ->

        val parameters = navBackStackEntry.toRoute<Routes.RegistrationDetailScreen>()

        RegistrationDetail(parameters.registrationInfo) {
            navController.popBackStack()
        }

    }
}