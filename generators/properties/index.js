var Generator=require('yeoman-generator');
var path=require('path');

module.exports=class extends Generator{

	initialing(){
		this.config.appName=this.options.appName;
    this.config.databaseType=this.options.databaseType;
    this.config.propertiesType=this.option.propertiesType;

	}

	copyFiles(){
		this.fs.copyTpl(
			this.templatePath(this.config.propertiesType),
			this.destinationRoot('uhis-rest/src/main/resources'),
			{appName: this.config.appName, databaseType: this.config.databaseType}
			);
	}

};
