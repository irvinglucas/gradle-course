// It's recommended to always start with the plugin block
plugins {
    // java-library
    id("java-library")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}