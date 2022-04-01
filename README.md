# Tweeze
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
    //initialize view
    var twitterUsernameView: TwitterUsernameView = findViewById(R.id.twitter_username_view) 
    
    //set username
    twitterUsernameView.username = "McDerek_" //output @McDerek_

    //customize textview
    twitterUsernameView.textView.setTextColor(Color.GREEN)

```

