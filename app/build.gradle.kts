plugins {
    id("my-application")
}

application {
    applicationName = "gradle-course-app"
    mainClass = "com.example.MyApplication"
}

dependencies {
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
}