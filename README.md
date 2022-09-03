# Tweeze
![Jitpack](https://img.shields.io/jitpack/v/github/kojofosu/Tweeze?style=for-the-badge&color=2F9319)

Tweeze is an android twitter library

## Setup

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        //...omitted for brevity
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```groovy
dependencies {
   implementation "com.github.kojofosu:Tweeze:$tweeze_version"
}
```

![Tweeze](https://user-images.githubusercontent.com/20203694/161426931-9cb8c2e1-cd14-4fa1-aa47-3ec784d8ff09.png)


## TwitterDisplayNameView
This view makes it convenient to set twitter display names. It exposes a method that adds the verified badge to users that are verified, just pass the `isVerified` response from the Twitter API.

Declare it in your xml layout
```xml
<com.mcdev.tweeze.TwitterDisplayNameView
    android:id="@+id/twitter_display_name_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```

Set display name programmatically
```kotlin
var twitterDisplayNameView: TwitterDisplayNameView = findViewById(R.id.twitter_display_name_view)

/* Sets the display name
* If the verified status is true, verified badge is shown, if false it's not shown
* Verified badge Type (Optional) comes in 3 forms, DEFAULT : Blue verified badge, WHITE and BLACK to fit well in every background color */
twitterDisplayNameView.setDisplayName("FOSU", true, VerifiedBadge.BLACK)

// set text size
twitterDisplayNameView.textSize = 20

// customize text view for display name
twitterDisplayNameView.customizeDisplayName.setTextColor(Color.RED)
```

## TwitterUsernameView
This view makes it convenient to set twitter usernames. It prepends the @ symbol automatically when ever you forget to add it.

Declare it in your xml layout
```xml
<!--Twitter Username View-->
<com.mcdev.tweeze.TwitterUsernameView
    android:id="@+id/twitter_username_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```

Set username programmatically
```kotlin
// initialize view
var twitterUsernameView: TwitterUsernameView = findViewById(R.id.twitter_username_view) 
    
// set username
twitterUsernameView.username = "McDerek_" // output @McDerek_

// get username with the @ symbol
var myUsername = twitterUsernameView.username // output @McDerek_

// get username without the @ symbol
var myUsernameWithoutSymbol = twitterUsernameView.usernameWithoutSymbol // output McDerek_

// customize textview
twitterUsernameView.customizeTextView.setTextColor(Color.GREEN) // change text color
twitterUsernameView.customizeTextView.textSize = 20f // set text size

```

