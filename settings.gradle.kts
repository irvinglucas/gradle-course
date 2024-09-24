// Defining a name for the Root Project
rootProject.name = "Gradle Course Project"

pluginManagement {
    repositories.gradlePluginPortal() // for general use plugins
    repositories.google() // if you're building an android app.

    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

include("app")
include("business-logic")
include("data-model")