plugins {
    id("my-java-library")
}

dependencies {
    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.slf4j:slf4j-api:1.7.36")
}

/**
 * A configuration block is a kind of container that summarizes dependencies and artifacts, so
 * Jar files, that belong together when looking at a project from a certain perspective.
 */
//configurations {
//    compileClasspath // compile-time "view" (aka variant)f
//    runtimeClasspath // runtime "view" (aka variant)
//}