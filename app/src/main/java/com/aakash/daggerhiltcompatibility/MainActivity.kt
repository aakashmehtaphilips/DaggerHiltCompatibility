package com.aakash.daggerhiltcompatibility

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aakash.daggerhiltcompatibility.ui.theme.DaggerHiltCompatibilityTheme
import com.philips.c2me.core.tagger.IAnalytics
import com.philips.c2me.core.util.ExternalLink
import com.philips.c2me.subscription.SubscriptionService
import com.philips.c2me.subscription.model.Configuration
import com.philips.c2me.subscription.model.DlsThemeModel
import com.philips.c2me.subscription.model.ExternalLinks
import com.philips.platform.appinfra.AppInfra
//import com.philips.platform.appinfra.AppInfra
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var greetingMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DHCApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerHiltCompatibilityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = greetingMessage,
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        val config = Configuration(
                            AppInfra.Builder().build(this),
                            "prasad.devadiga@philips.com",
                            externalLinks = ExternalLinks(
                                noSubscription = ExternalLink(""),
                                manageSubscription = ExternalLink(""),
                                termsOfUse = ExternalLink(""),
                                externalLinkCallback = { url ->
                                    Log.i(
                                        "ExternalLinksImpl",
                                        "External link callback to proposition: $url"
                                    )
                                }
                            ),
                            callBack = { Log.i("LaunchSubscriptionViewModel", "Callback invoked") },
                            productGroupName = "C2ME",
                            analytics = object : IAnalytics {
                                override fun collectLifecycleData(activity: Activity) {

                                }

                                override fun onEvent(key: String, value: String) {

                                }

                                override fun onEvent(key: String, param: HashMap<String, Any>) {

                                }

                                override fun onPageChange(
                                    pageName: String,
                                    param: HashMap<String, Any>
                                ) {

                                }

                                override fun onUserAction(actionName: String, value: String) {

                                }

                                override fun pauseCollectingLifecycleData() {

                                }

                                override fun setAnalyticsCollectionEnabled(value: Boolean) {

                                }

                                override fun trackActionWithInfo(
                                    specialEvents: String,
                                    param: HashMap<String, Any>
                                ) {

                                }

                                override fun trackExitLink(
                                    link: String,
                                    param: HashMap<String, Any>
                                ) {

                                }
                            })
                        val service = SubscriptionService(config)
                        service.launchAsActivity(
                            this,
                            "",
                            emptyList(),
                            DlsThemeModel(),
                            {
                                ""
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            onClick()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerHiltCompatibilityTheme {
        Greeting("Android")
    }
}