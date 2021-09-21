List inLineScripts = []
List scriptNames = []
scriptNames.add("FooBar.groovy")
println "===================================================="
println "===========Removed scripts which are used==========="
println "===================================================="
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each{
	String buildFullName = it.getFullName()
	int lastBuildNumber
	if(it.getLastBuild() != null){
		lastBuildNumber = it.getLastBuild().toString().split("#")[-1] as Integer
		try{
			String scriptPath = Jenkins.instance.getItemByFullName(buildFullName).getBuildByNumber(lastBuildNumber).parent.definition.scriptPath
			String scriptName = scriptPath.split("/")[-1]
			if(scriptNames.contains(scriptName)){
				println "Script - ${scriptPath} is used in job ${buildFullName}"
			}
		} catch (Exception e) {
			inLineScripts.add(buildFullName)
		}
	}
}
println "===================================================="
println "===========Pipelines with inline scipts============="
println "===================================================="
for(String jobName : inLineScripts){
	println jobName
}