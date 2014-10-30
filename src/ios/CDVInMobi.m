//
//  CDVInMobi.m
//  InMobiPlugin
//
//  Created by Dmitriy Devayev on 10/8/14.
//
//

#import "CDVInMobi.h"
#import <Cordova/CDV.h>

#import "IMBanner.h"
#import "IMBannerDelegate.h"
#import "IMInterstitial.h"
#import "IMInterstitialDelegate.h"
#import "IMIncentivisedDelegate.h"
#import "IMNative.h"
#import "IMNativeDelegate.h"
#import "IMError.h"
#import "InMobiAnalytics.h"
#import "InMobi.h"
#import "IMConstants.h"

@implementation CDVInMobi
- (void)showAd:(CDVInvokedUrlCommand *)command
{
    [InMobi initialize:@"Insert InMobi property ID here"];
    
    [self.commandDelegate runInBackground:^{
        NSLog(@"InMobi plugin called");
        
        self.adInterstitial = [[IMInterstitial alloc] initWithAppId:@"Insert InMobi property ID here"];
        self.adInterstitial.delegate = self;
        [self.adInterstitial loadInterstitial];
        
        CDVPluginResult* pluginResult = nil;
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

- (void)interstitialDidReceiveAd:(IMInterstitial *)ad {
    NSLog(@"Loaded interstitial ad");
    [ad presentInterstitialAnimated:YES];
}
@end
