def jobFullName = "FOO/BAR"
def firstToKill = 1
def lastToKill = 1000
Jenkins.instance.getItemByFullName(jobFullName).builds.findAll { 
	it.number > firstToKill && it.number < lastToKill 
}.each { 
	it.finish(hudson.model.Result.ABORTED, new java.io.IOException("Aborting build"));
}