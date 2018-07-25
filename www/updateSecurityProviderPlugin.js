// Empty constructor
var UpdateSecurityProviderLoader = function(require, exports, module) {
    var exec = require('cordova/exec');

    function UpdateSecurityProvider() {}

    // The function that passes work along to native shells
    UpdateSecurityProvider.prototype.update = function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'UpdateSecurityProviderPlugin', 'update', null);
    };

    var updateSecurityProvider = new UpdateSecurityProvider();
    module.exports = updateSecurityProvider;
};

UpdateSecurityProviderLoader(require, exports, module);

cordova.define("cordova/plugin/UpdateSecurityProvider", UpdateSecurityProviderLoader);
