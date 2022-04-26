plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {

    compileSdk = AppInfo.compileSdk

    defaultConfig {
        applicationId = AppInfo.packageName
        minSdk = AppInfo.minSdk
        targetSdk = AppInfo.targetSdk
        versionCode = AppInfo.versionCode
        versionName = AppInfo.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    signingConfigs {
        create("release") {
            storeFile = project.properties["SIGNED_STORE_FILE"]?.let { file(it) }
            storePassword = project.properties["SIGNED_STORE_PASSWORD"].toString()
            keyAlias = project.properties["SIGNED_KEY_ALIAS"].toString()
            keyPassword = project.properties["SIGNED_KEY_PASSWORD"].toString()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

}

dependencies {
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation(project(":base"))
    implementation(project(":domain"))
    implementation(project(":data"))

    setDependencies(Libs.Basic)
    setDependencies(Libs.Network)
    setDependencies(Libs.AndroidX)
    setDependencies(Libs.JetPack)
    setDependencies(Libs.Kakao)
    setDependencies(Libs.KTX)
    setDependencies(Libs.UI)
}

kapt {
    correctErrorTypes = true
}