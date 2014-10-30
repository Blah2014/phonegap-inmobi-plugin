phonegap-inmobi-plugin
======================

This plugin provides an implementation of InMobi Native Interstitial Ad.

<h2>Supported platforms</h2>
<ul>
  <li>iOS</li>
  <li>Android</li>
</ul>

<h2>Installation</h2>

<h5>Cordova CLI</h5>
```
cordova plugin add https://github.com/Blah2014/phonegap-inmobi-plugin
```

<h5>Phonegap CLI</h5>
```
phonegap local plugin add https://github.com/Blah2014/phonegap-inmobi-plugin
```

<h5>plugman CLI</h5>
```
plugman --platform ios --project ./platforms/ios --plugin https://github.com/Blah2014/phonegap-inmobi-plugin
```

## Usage
```
<script>
    InMobi.showAd();
</script>
```

## Configuration
##### iOS
###### Adding the SDK to your Project
Download latest InMobi SDK for iOS

Drag and drop under Xcode project Libs folder from downloaded iOS SDK 4.x

###### Adding Frameworks
You will need to add some optional and mandatory frameworks to your Xcode project for the SDK to work correctly. The frameworks required to compile the InMobi SDK 4.x monetization library are given below:

* AdSupport.framework
* AudioToolbox.framework
* AVFoundation.framework
* CoreLocation.framework
* CoreTelephony.framework
* EventKit.framework
* EventKitUI.framework
* MediaPlayer.framework
* MessageUI.framework
* Security.framework
* Social.framework
* StoreKit.framework
* SystemConfiguration.framework
* libsqlite3.0.dylib
* libz.dylib

![Adding Frameworks](https://github.com/Blah2014/phonegap-inmobi-plugin/blob/gh-pages/inmobi/Sample-Integration-2.png)
If you use iOS 8, please add the NSLocationWhenInUseUsageDescription flag to your info.plist file.

###### Adding Additional Build Settings
Add the -ObjC flag to the Other Linker Flags. To do so, perform the below steps:

1. Open your project in Xcode.
2. Select Application Target > Build Settings.
3. In the Search field, search for 'Other Linker Flags'.
4. Add the -ObjC flag.

![AddObjc](https://github.com/Blah2014/phonegap-inmobi-plugin/blob/gh-pages/inmobi/AddObjc.png)

###### Insert InMobi property ID
In CDVInMobi.m replace "Insert InMobi property ID here" in two places with your siteID from InMobi property.

##### Android
###### Adding the SDK to your Project
Download latest InMobi SDK for Android

###### Configuration

Copy the InMobi-4.x.x.jar file to your project by performing the steps given below.

1. Create a subdirectory named libs in the root directory of your project.
2. Copy the InMobi-4.x.x.jar file into the libs directory.

To add the JAR files to your project, perform the following steps:

1. Right-click your project from the Package Explorer tab.
2. Select Properties.
3. Select Java Build Path from the left navigation area.
4. Select the Libraries tab from the main window.
5. Click Add JARs...
6. Select the InMobi-4.x.x.jar file that you copied earlier to the libs directory.
7. Click OK to add the InMobi SDK to your Android project.
 
###### Manifest File Changes
Include the below within the &#60;application&#62; tag.
```
    <activity android:name="com.inmobi.androidsdk.IMBrowserActivity"
		    android:configChanges="keyboardHidden|orientation|keyboard|smallestScreenSize|screenSize"
		    android:theme="@android:style/Theme.Translucent.NoTitleBar"
		    android:hardwareAccelerated="true" />
```
Include the below within the &#60;manifest&#62; tag.
```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.CALL_PHONE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_LOGS" />
    <uses-permission android:name="android.permission.READ_CALENDAR"/>
    <uses-permission android:name="android.permission.WRITE_CALENDAR"/>
    <uses-permission android:name="com.google.android.gms.permission.ACTIVITY_RECOGNITION" />
```




