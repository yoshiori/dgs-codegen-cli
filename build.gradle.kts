import org.mikeneck.graalvm.GenerateNativeImageConfigTask

plugins {
  id("java")
  id("org.mikeneck.graalvm-native-image") version "v1.0.0"
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-core:5.1.2")
}

nativeImage {
    graalVmHome = System.getenv("JAVA_HOME")
    mainClass ="com.netflix.graphql.dgs.codegen.CodeGenCliKt"
    executableName = "dgs-codegen"
    outputDirectory = file("$buildDir/executable")
    arguments(
        "--no-fallback",
        "--enable-all-security-services",
        "--report-unsupported-elements-at-runtime"
    )
}
