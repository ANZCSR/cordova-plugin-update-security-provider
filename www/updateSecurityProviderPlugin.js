// Empty constructor
function UpdateSecurityProviderPlugin() {}

// The function that passes work along to native shells
UpdateSecurityProviderPlugin.prototype.update = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, 'UpdateSecurityProviderPlugin', 'update', null);
}

// Installation constructor that binds UpdateSecurityProviderPlugin to window
UpdateSecurityProviderPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.updateSecurityProviderPlugin = new UpdateSecurityProviderPlugin();
  return window.plugins.updateSecurityProviderPlugin;
};
cordova.addConstructor(UpdateSecurityProviderPlugin.install);
