var Generator = require('yeoman-generator');
var path = require('path');

module.exports = class extends Generator {
  initialing() {
    this.config.appName = this.options.appName;
    this.config.restName = this.options.restName;
    this.config.databaseType = this.options.databaseType;
    this.config.propertiesType = this.options.propertiesType;
  }

  copyFiles() {
    this.fs.copyTpl(
      this.templatePath(this.config.propertiesType),
      this.destinationPath(`${this.config.restName}/src/main/resources`),
      { appName: this.config.appName, databaseType: this.config.databaseType }
    );
  }
};
