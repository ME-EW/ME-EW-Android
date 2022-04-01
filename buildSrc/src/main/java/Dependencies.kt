import org.gradle.api.artifacts.dsl.DependencyHandler

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

    data class AnnotationProcessor(private val dependencyName: Any) :
        DependencyType(dependencyName) {
        override fun getDependencyTypeValue(): String = "annotationProcessor"
    }
}

interface Libs {
    fun getDependencies(): List<DependencyType>

    object Basic : Libs {
        private const val GLIDE = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        private const val GLIDE_COMPILER =
            "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
        private const val MATERIAL =
            "com.google.android.material:material:${Versions.materialVersion}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(GLIDE),
                DependencyType.AnnotationProcessor(GLIDE_COMPILER),
                DependencyType.Implementation(MATERIAL)
            )
        }
    }

    object Network : Libs {
        private const val GSON = "com.google.code.gson:gson:${NetworkVersion.gsonVersion}"
        private const val RETROFIT2 =
            "com.squareup.retrofit2:retrofit:${NetworkVersion.retrofitVersion}"
        private const val CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:${NetworkVersion.retrofitVersion}"
        private const val OKHTTP_BOM =
            "com.squareup.okhttp3:okhttp-bom:${NetworkVersion.okhttpVersion}"
        private const val LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor"
        private const val OKHTTP3 = "com.squareup.okhttp3:okhttp"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(GSON),
                DependencyType.Implementation(RETROFIT2),
                DependencyType.Implementation(CONVERTER_GSON),
                DependencyType.Implementation(OKHTTP_BOM),
                DependencyType.Implementation(LOGGING_INTERCEPTOR),
                DependencyType.Implementation(OKHTTP3)
            )
        }
    }

    object AndroidX : Libs {
        private const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${AndroidXVersion.constraintLayoutVersion}"
        private const val coreKtx = "androidx.core:core-ktx:${AndroidXVersion.coreKtx}"
        private const val appCompat = "androidx.appcompat:appcompat:${AndroidXVersion.appCompat}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(appCompat),
                DependencyType.Implementation(constraintlayout),
                DependencyType.Implementation(coreKtx)
            )
        }
    }

    object JetPack : Libs {
        private const val hilt = "com.google.dagger:hilt-android:${JetPackVersion.hilt}"
        private const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${JetPackVersion.hilt}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(hilt),
                DependencyType.Kapt(hiltCompiler)
            )
        }

    }

    object Kakao : Libs {
        private const val user = "com.kakao.sdk:v2-user:${Versions.kakao}"
        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(user)
            )
        }
    }

}

fun DependencyHandler.setDependencies(libs: Libs) {
    libs.getDependencies().forEach {
        add(it.getDependencyTypeValue(), it.dependency)
    }
}