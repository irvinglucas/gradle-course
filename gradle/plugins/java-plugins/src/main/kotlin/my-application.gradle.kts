import com.example.JarCount

plugins {
    id("my-java-base")
    id("application")
}

tasks.register<Zip>("bundle-to-go") {
    group = "Custom Distribution"
    description = "Packages app + dependencies as a to-go copy of the built software."

    from(tasks.jar)
    from(configurations.runtimeClasspath)

    // set destination directory. Do not put static directory
    destinationDirectory.set(layout.buildDirectory.dir("custom-distributions"))
}

tasks.register<JarCount>("countJars") {
    group = "Custom Distribution"
    description = "Counts the number of jars this project produces"
    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("generated/count.txt"))
}

/**
 * This is a task without a type, consequently without an action, so this is a lifecycle task.
 */
tasks.register("buildAll") {
    group = "Custom Build"
    description = "This task creates a whole new build lifecycle task."

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}