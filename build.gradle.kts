buildscript {
    val kotlin_version by extra("1.4.30")
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }

    val kotlinVersion: String by project
    val sqlDelightVersion: String by project
    val ktorVersion: String by project

    dependencies{
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}