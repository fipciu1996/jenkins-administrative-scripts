int numOfJobs = 0
def numDaysBack = 90
def cutOfDate = System.currentTimeMillis() - 1000L * 60 * 60 * 24 * numDaysBack
List builds = []
println "===================================================="
println "Jobs with last build older than ${numDaysBack} days"
println "===================================================="
Jenkins.instance.getAllItems(Job.class).each{ job ->
	job.findAll{
		job.getLastBuild() != null && job.getLastBuild().getStartTimeInMillis() < cutOfDate
	}.each {
		numOfJobs++
		println it.fullName
	}
}
return numOfJobs