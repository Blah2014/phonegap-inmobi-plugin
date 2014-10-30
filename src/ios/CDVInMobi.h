//
//  CDVInMobi.h
//  InMobiPlugin
//
//  Created by Dmitriy Devayev on 10/8/14.
//
//

#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

#import "IMInterstitial.h"
#import "IMInterstitialDelegate.h"

@interface CDVInMobi : CDVPlugin
- (void)showAd:(CDVInvokedUrlCommand*)command;
@property (nonatomic, strong) IMInterstitial *adInterstitial;
@end