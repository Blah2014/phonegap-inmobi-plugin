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
## Configuration
##### iOS
###### Adding the SDK to your Project
Download latest InMobi SDK

Drag and drop under Xcode project Libs folder from downloaded iOS SDK

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


