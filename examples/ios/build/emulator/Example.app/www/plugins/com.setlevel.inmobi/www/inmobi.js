cordova.define("com.setlevel.inmobi.InMobi", function(require, exports, module) { //
//  
//  InMobiPlugin
//
//  Created by Dmitriy Devayev on 10/8/14.
//
//

var cordova = require('cordova');

function InMobi() {
	var self = this;

	self.init = function() {
		cordova.exec(function(){}, function(){}, "CDVInMobi", "init", []);
	};

	self.showAd = function() {
		cordova.exec(function(){}, function(){}, "CDVInMobi", "showAd", []);
	};
}

module.exports = new InMobi();

});
