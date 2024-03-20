import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    value: String = ""
) {
    var visibility by remember { mutableStateOf(false) }
    var passwordText by remember { mutableStateOf(value) }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        value = passwordText,
        onValueChange = { passwordText = it },
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                val imageVector = if (visibility) Icons.Default.Close else Icons.Default.Edit
                Icon(
                    imageVector,
                    contentDescription = if (visibility) "Hide password" else "Show password"
                )
            }
        }
    )
}