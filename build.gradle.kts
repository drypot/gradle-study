plugins {
    java
}

group = "com.drypot"
version = "1.0-SNAPSHOT"

java {                                      (4)
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}


task("helloWorld", JavaExec::class) {
  main = "com.drypot.HelloWorld"
  classpath = sourceSets["main"].runtimeClasspath
}

task("dumpTimeZone", JavaExec::class) {
  main = "com.drypot.DumpTimeZone"
  classpath = sourceSets["main"].runtimeClasspath
}

task("helloWorldGradle") {
  doLast {
    println("Hello World Gradle !")
  }
}
