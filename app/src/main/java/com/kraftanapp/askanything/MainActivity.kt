package com.kraftanapp.askanything

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kraftanapp.askanything.ui.theme.AskAnythingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AskAnythingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenMain(intent?.handleIntent())
                }
            }
        }
    }
}


private fun Intent.handleIntent() = when (action) {
        // When the BII is matched, Intent.Action_VIEW will be used
        Intent.ACTION_VIEW -> handleIntent(data)
        // Otherwise start the app as you would normally do.
        else -> OpenApp.Normally
    }


private fun handleIntent(data: Uri?): OpenApp.Shortcut {
    return OpenApp.Shortcut(Feature.Transfer())
}

@Preview(showBackground = true)
@Composable
fun ScreenMainPreview() {
    AskAnythingTheme {
        ScreenMain(OpenApp.Normally)
    }
}