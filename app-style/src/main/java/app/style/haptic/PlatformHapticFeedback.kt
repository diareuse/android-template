package app.style.haptic

import android.view.View
import androidx.compose.ui.hapticfeedback.*

class PlatformHapticFeedback(
    private val view: View
) : HapticFeedback {

    override fun performHapticFeedback(hapticFeedbackType: HapticFeedbackType) {
        val field = hapticFeedbackType::class.java
            .declaredFields.firstOrNull { it.name == "value" }
            ?: return
        field.isAccessible = true
        view.performHapticFeedback(field.getInt(hapticFeedbackType))
    }

}