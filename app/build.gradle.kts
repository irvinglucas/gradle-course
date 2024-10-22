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
    runtimeOnly("org.slf4j:slf4j-simple:1.7.36") // it's plugged in only at runtime
}