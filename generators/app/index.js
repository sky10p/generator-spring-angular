'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');
const rename = require('gulp-rename');

function toCamelCase(snake_case){
  var camelCase = snake_case.replace(/-([a-z])/g, function(coincidence){
    return coincidence[1].toUpperCase();
  });

  return camelCase.charAt(0).toUpperCase() + camelCase.slice(1);
}

function addReplace(path, regexExpression, replaceBy){
    path.basename = path.basename.replace(regexExpression, replaceBy);
      path.dirname = path.dirname.replace(regexExpression, replaceBy);
}

module.exports = class extends Generator {
  prompting() {

    this.log(
      yosay(`Welcome to the rpa generator ${chalk.red('generator-rpa-spring-angular')}!`)
    );


  }

  async askForProjectName() {
    this.answers = await this.prompt([{
      type: 'input',
      name: 'projectName',
      message: 'Your project name(lowercase characters)',
      default: this.appname
    }]);

  }

  async askForSubModulesProjectNames(){
    this.submodulesAnswers = await this.prompt([{
      type: 'input',
      name: 'businessLogicName',
      message: 'Business Logic Submodule Name?',
      default: this.answers.projectName + "-business-logic"
    },
    {
      type: 'input',
      name: 'persistenceName',
      message: 'Persistence Submodule Name?',
      default: this.answers.projectName + "-persistence"
    },
    {
      type: 'input',
      name: 'dataName',
      message: 'Data Submodule Name?',
      default: this.answers.projectName + "-data"
    },
    {
      type: 'input',
      name: 'restName',
      message: 'Rest Submodule Name?',
      default: this.answers.projectName + "-rest"
    },
    {
      type: 'input',
      name: 'webappName',
      message: 'WebApp Submodule Name?',
      default: this.answers.projectName + "-webapp"
    }]);


  }





  copyFolders(){

    this.registerTransformStream(rename(path=> {
      addReplace(path, /(uhis-business-logic)/g, this.submodulesAnswers.businessLogicName);
      addReplace(path, /(uhis-data)/g, this.submodulesAnswers.dataName);
      addReplace(path, /(uhis-persistence)/g, this.submodulesAnswers.persistenceName);
      addReplace(path, /(uhis-rest)/g, this.submodulesAnswers.restName);
      addReplace(path, /(uhis-webapp)/g, this.submodulesAnswers.webappName);

      addReplace(path, /(uhis)/g, this.answers.projectName);

      return path;

    }));

    this.fs.copyTpl(
      this.templatePath(),
      this.destinationPath(),
         {
           appName:this.answers.projectName,
           appName_CamelCase: toCamelCase(this.answers.projectName),
           APPNAME_UPPERCASE:this.answers.projectName.toUpperCase(),
           business_logic: this.submodulesAnswers.businessLogicName,
           business_logic_camelcase:toCamelCase(this.submodulesAnswers.businessLogicName),
           data_name: this.submodulesAnswers.dataName,
           data_camelcase:toCamelCase(this.submodulesAnswers.dataName),
           persistence_name: this.submodulesAnswers.persistenceName,
           persistence_camelcase:toCamelCase(this.submodulesAnswers.persistenceName),
           rest_name: this.submodulesAnswers.restName,
           rest_camelcase: toCamelCase(this.submodulesAnswers.restName),
           webapp_name: this.submodulesAnswers.webappName,
           webapp_camelcase: toCamelCase(this.submodulesAnswers.webappName),

         }
    );
  }

  generated(){
    this.log(
      yosay(`${chalk.red('generator-rpa-spring-angular')} generated`)
    );
  }


};
