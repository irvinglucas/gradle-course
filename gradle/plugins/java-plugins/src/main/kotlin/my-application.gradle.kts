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

tasks.register("buildAll") {
    description = "This task creates a whole new build lifecycle."

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}