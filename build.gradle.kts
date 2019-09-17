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

tasks.create("helloWorldGradle") {
  group = "Custom"
  doLast {
    println("Hello World Gradle !")
  }
}

tasks.create<JavaExec>("helloWorld") {
  group = "Custom"
  main = "com.drypot.HelloWorld"
  classpath = sourceSets["main"].runtimeClasspath
}

tasks.create<JavaExec>("dumpTimeZone") {
  group = "Custom"
  main = "com.drypot.DumpTimeZone"
  classpath = sourceSets["main"].runtimeClasspath
}

tasks.create<Copy>("copy") {
  group = "Custom"
  from("copy-test/src")
  into("copy-test/dest")
}

tasks.create<Zip>("zip") {
  group = "Custom"
  archiveFileName.set("sample.zip")
  destinationDirectory.set(file("copy-test/zip"))
  from("copy-test/src")
}
