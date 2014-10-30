
var cordova = require('cordova');

function InMobi() {
	var self = this;

	//self.showAd = function(successCallback, errorCallback) {
		//cordova.exec(successCallback, errorCallback, "InMobi", "showAd", []);
	//};
	self.init = function() {
		cordova.exec(function(){}, function(){}, "CDVInMobi", "init", []);
	};

	self.showAd = function() {
		cordova.exec(function(){}, function(){}, "CDVInMobi", "showAd", []);
	};

	//self.showAd = function(value) {
		//alert(value);
	//};
}

module.exports = new InMobi();
