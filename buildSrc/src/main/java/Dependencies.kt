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
        private const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        private const val appCompat = "androidx.appcompat:appcompat:${AndroidXVersion.appCompat}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(appCompat),
                DependencyType.Implementation(constraintlayout),
                DependencyType.Implementation(coreKtx),
                DependencyType.Implementation(kotlinStdlib)
            )
        }
    }

    object JetPack : Libs {
        private const val hilt = "com.google.dagger:hilt-android:${JetPackVersion.hilt}"
        private const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${JetPackVersion.hilt}"
        private const val navigationKtx = "androidx.navigation:navigation-fragment-ktx:${JetPackVersion.navigation}"
        private const val navigationUiKtx ="androidx.navigation:navigation-ui-ktx:${JetPackVersion.navigation}"
        private const val navigationDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${JetPackVersion.navigation}"
        private const val preferencesDataStore = "androidx.datastore:datastore-preferences:${JetPackVersion.dataStore}"
        private const val protoDataStore = "androidx.datastore:datastore:${JetPackVersion.dataStore}"
        private const val protoDataStoreBuf = "com.google.protobuf:protobuf-javalite:${Versions.protoBufJavaLite}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(hilt),
                DependencyType.Kapt(hiltCompiler),
                DependencyType.Implementation(navigationKtx),
                DependencyType.Implementation(navigationUiKtx),
                DependencyType.Implementation(navigationDynamicFeatures),
                DependencyType.Implementation(preferencesDataStore),
                DependencyType.Implementation(protoDataStore),
                DependencyType.Implementation(protoDataStoreBuf)
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

    object KTX : Libs {

        private const val activity = "androidx.activity:activity-ktx:${KTXVersion.activity}"
        private const val fragment = "androidx.fragment:fragment-ktx:${KTXVersion.fragment}"
        private const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${KTXVersion.lifeCycle}"
        private const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${KTXVersion.lifeCycle}"
        private const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${KTXVersion.lifeCycle}"
        private const val collection = "androidx.collection:collection-ktx:${KTXVersion.collection}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(activity),
                DependencyType.Implementation(fragment),
                DependencyType.Implementation(viewModel),
                DependencyType.Implementation(liveData),
                DependencyType.Implementation(runtime),
                DependencyType.Implementation(collection)
            )
        }
    }

    object UI : Libs {
        private const val dotIndicator = "com.tbuonomo:dotsindicator:${Versions.dotIndicator}"
        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.Implementation(dotIndicator)
            )
        }
    }

    object Flipper: Libs {
        private const val flipper = "com.facebook.flipper:flipper:${FlipperVersion.flipperVersion}"
        private const val soLoader = "com.facebook.soloader:soloader:${FlipperVersion.soLoaderVersion}"
        private const val noop = "com.facebook.flipper:flipper-noop:${FlipperVersion.flipperVersion}"
        private const val network = "com.facebook.flipper:flipper-network-plugin:${FlipperVersion.networkVersion}"

        override fun getDependencies(): List<DependencyType> {
            return listOf(
                DependencyType.DebugImplementation(flipper),
                DependencyType.DebugImplementation(soLoader),
                DependencyType.ReleaseImplementation(noop),
                DependencyType.DebugImplementation(network)
            )
        }
    }
}

fun DependencyHandler.setDependencies(libs: Libs) {
    libs.getDependencies().forEach {
        add(it.getDependencyTypeValue(), it.dependency)
    }
}