plugins {
    id("my-application")
}

dependencies {
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
}