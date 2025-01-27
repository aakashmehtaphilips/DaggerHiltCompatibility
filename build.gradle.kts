// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
}

buildscript {
    repositories {
        val companyMaven = { companyUrl: String ->
            maven {
                credentials {
                    username = "readonly"
                    password = "123qweasdzxc"
                }
                setUrl(companyUrl)
            }
        }
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-pkgs-android-release")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-plugins-release-local")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-jcenter-remote")
    }
    dependencies {
        classpath("com.philips.cdp:cdpSCM:5.5.0") {
            exclude("com.android.support")
        }
        classpath("org.jfrog.buildinfo:build-info-extractor-gradle:5.1.4")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
}