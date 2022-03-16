sealed class DependencyType(val dependency: Any) {
    abstract fun getDependencyTypeValue(): String

    data class Implementation(private val dependencyName: Any) : DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "implementation"
    }

    data class TestImplementation(private val dependencyName: Any) :
        DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "testImplementation"
    }

    data class AndroidTestImplementation(private val dependencyName: Any) :
        DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "androidTestImplementation"
    }

    data class DebugImplementation(private val dependencyName: Any) :
        DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "debugImplementation"
    }

    data class ReleaseImplementation(private val dependencyName: Any) :
        DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "releaseImplementation"
    }

    data class Kapt(private val dependencyName: Any) : DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "kapt"
    }

    data class AnnotationProcessor(private val dependencyName: Any) : DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "annotationProcessor"
    }
}

interface Libs {
    fun getDependencies(): List<DependencyType>
}