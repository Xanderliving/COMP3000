plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.picknmixologist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.picknmixologist"
        minSdk = 25
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.test.espresso:espresso-intents:3.5.1")
    implementation("org.mindrot:jbcrypt:0.4")
    implementation("androidx.test.ext:junit:1.1.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation ("junit:junit:4.13.1")
    testImplementation ("org.robolectric:robolectric:4.5.1")
    testImplementation ("androidx.test:core:1.4.0")
    testImplementation ("org.mockito:mockito-core:3.12.4")
    testImplementation("junit:junit:4.12")
    testImplementation ("org.robolectric:robolectric:4.6.1")


}