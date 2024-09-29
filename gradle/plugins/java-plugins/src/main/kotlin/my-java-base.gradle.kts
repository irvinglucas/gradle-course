plugins {
    id("java")
    id("com.diffplug.spotless")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8" // best practice
}

// another way to configure tasks if the accessor is not available for some reason
//tasks.named("clean") {
//    println("THE TASK $name FROM ${project.name} WAS SUCCESSFULLY RAN.")
//}

allprojects.forEach { project ->
    if (project.name == "app") {
        tasks.named("clean") {
            println("The task named CLEAN, from APP project, has its own string.")
        }
    }

    if (project.name == "business-logic") {
        tasks.named("clean") {
            println("This task cleans everything about business-logic project :)")
        }
    }

    if (project.name == "data-model") {
        tasks.named("clean") {
            println("This task makes this project clean when it's about data-model")
        }
    }
}

//
//tasks.compileJava {
//    options.encoding = "UTF-8"
//}
//
//tasks.compileTestJava {
//    options.encoding = "UTF-8"
//}

//tasks.test {
//
//}
//
//tasks.javadoc {
//
//}