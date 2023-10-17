pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidCodingChallenge"
include(":app")
include(":common")
include(":feature:launches:presentation")
include(":feature:launches:api")
include(":feature:launches:domain")
include(":domain:network")
include(":domain:local")
