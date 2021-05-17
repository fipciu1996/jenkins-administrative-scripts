Jenkins.instance.getAllItems(Job.class).each {job ->
	job.fullName.each{ jobFullName ->
		Jenkins.instance.getItemByFullName(jobFullName).findAll { it.logRotator }
				.each {
					println "--------------------"
					println "Job Name: ${jobFullName}"
					println "Number of kept builds: ${it.logRotator.getNumToKeepStr()}"
					println "Days to keep: ${it.logRotator.getDaysToKeepStr()}"
					println "How many days artifacts will be keep: ${it.logRotator.getArtifactDaysToKeepStr()}"
					println "Artifacts from how many days will be keep: ${it.logRotator.getArtifactNumToKeepStr()}"
					it.logRotator.perform(it)
					println "Log rotation performed"
				}
	}
}