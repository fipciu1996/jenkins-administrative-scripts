def scriptsToVerify = ''' Foo.groovy
Bar.groovy'''.split("\n")
def inLineScripts = []
def usedScripts = []
println "===================================================="
println "===========Scripts which are unused================="
println "===================================================="
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each{
	String buildFullName = it.getFullName()
	int lastBuildNumber
	if(it.getLastBuild() != null){
		lastBuildNumber = it.getLastBuild().toString().split("#")[-1] as Integer
		try{
			String scriptPath = Jenkins.instance.getItemByFullName(buildFullName).getBuildByNumber(lastBuildNumber).parent.definition.scriptPath
			String scriptName = scriptPath.split("/")[-1]
			if(scriptsToVerify.contains(scriptName)){
				usedScripts.add(scriptName)
			}
		} catch (Exception e) {
			inLineScripts.add(buildFullName)
		}
	}
}

for(def scriptToVerify : scriptsToVerify){
	if(!usedScripts.contains(scriptToVerify)){
		println "${scriptToVerify} is not used"
	}
}