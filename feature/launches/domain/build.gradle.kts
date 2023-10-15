@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java-library")
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project(":feature:launches:api"))
    implementation(project(":domain:network"))
    implementation(libs.koin.core)
    implementation(libs.coroutines)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}