plugins {
    java
}

group = "com.drypot"
version = "1.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}

tasks.register("helloWorldGradle") {
  group = "Custom"
  doLast {
    println("Hello World Gradle !")
  }
}

tasks.register<JavaExec>("helloWorld") {
  group = "Custom"
  main = "com.drypot.HelloWorld"
  classpath = sourceSets.main.get().runtimeClasspath
}

tasks.register<JavaExec>("dumpTimeZone") {
  group = "Custom"
  main = "com.drypot.DumpTimeZone"
  classpath = sourceSets.main.get().runtimeClasspath
}

tasks.register<Copy>("copy") {
  group = "Custom"
  from("copy-test/src")
  into("copy-test/dest")
}

tasks.create<Zip>("zip") {
  group = "Custom"
  archiveFileName.set("sample.zip")
  destinationDirectory.set(file("copy-test/zip"))
  from("copy-test/src")

//  from("$buildDir/toArchive") {
//    exclude("**/*.pdf")
//  }
//
//  from("$buildDir/toArchive") {
//    include("**/*.pdf")
//    into("docs")
//  }

}

//tasks.register<Copy>("unpackFiles") {
//  from(zipTree("src/resources/thirdPartyResources.zip"))
//  into("$buildDir/resources")
//}

tasks.register("ensureDirectory") {
  group = "Custom"
  doLast {
    mkdir("images")
  }
}

tasks.register<Copy>("copyFromStaging") {
  group = "Custom"
  from("src/main/webapp")
  into("$buildDir/explodedWar")
  rename("(.+)-staging(.+)", "$1$2")
}

tasks.register<Delete>("myClean") {
  group = "Custom"
  delete(buildDir)
}
