dependencyResolutionManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven{
            credentials {
                username = "readonly"
                password = "123qweasdzxc"
            }
            url = uri("https://artifactory-ehv.ta.philips.com/artifactory/iet-mobile-android-release-local")
        }
        maven{
            credentials {
                username = "readonly"
                password = "123qweasdzxc"
            }
            url = uri("https://artifactory-ehv.ta.philips.com/artifactory/iet-mobile-android-snapshot-local")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com/artifactory/HSDP-pkgs-android-release")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com:443/artifactory/dl-innersource-mvn-release")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com/artifactory/CDP2-Prop-pkgs-android-snapshot")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com/artifactory/platform-pkgs-android-snapshot-local")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com/artifactory/platform-pkgs-android-stage-local")
        }
        maven {
            url =
                uri("https://artifactory-ehv.ta.philips.com/artifactory/platform-pkgs-android-release-local")
        }
    }
}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "DaggerHiltCompatibility"
include(":app")
