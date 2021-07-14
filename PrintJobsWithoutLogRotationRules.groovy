
Jenkins.instance.getAllItems(Job.class).each { job ->
	Jenkins.instance.getItemByFullName(job.fullName).findAll { !it.logRotator }.each {
		println "--------------------"
		println "Job Name: ${job.fullName}"
	}
}
