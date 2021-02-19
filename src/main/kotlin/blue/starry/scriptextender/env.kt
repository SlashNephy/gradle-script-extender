package blue.starry.scriptextender

import org.gradle.api.Project
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Project.env(name: String): EnvReference {
    return EnvReference(name)
}

val Project.env: ReadOnlyProperty<Project, EnvReference>
    get() = object: ReadOnlyProperty<Project, EnvReference> {
        override fun getValue(thisRef: Project, property: KProperty<*>): EnvReference {
            return env(property.name)
        }
    }

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
