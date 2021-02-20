package blue.starry.scriptextender

import org.gradle.api.Project
import kotlin.properties.ReadOnlyProperty

fun Project.env(name: String): EnvReference {
    return EnvReference(name)
}

val Project.env: ReadOnlyProperty<Any?, EnvReference>
    get() = ReadOnlyProperty { _, property -> env(property.name) }

data class EnvReference(private val name: String) {
    val value: String
        get() = System.getenv(name) ?: error("Env: $name is not present.")

    val valueOrNull: String?
        get() = System.getenv(name)

    fun valueOrElse(default: () -> String): String {
        return valueOrNull ?: default()
    }

    val isPresent: Boolean
        get() = name in System.getenv()
}
