def folderName = "YOUR/FOLDER/NAME/"
int maxDaysToKepp = 4
def allJobs = hudson.model.Hudson.getInstance().getAllItems(Job.class).findAll { job -> job.getFullName().contains(folderName) }
for (def job : allJobs) {
	def nowTimestamp = new GregorianCalendar()
	def builds = job.getBuilds().findAll { build -> nowTimestamp.getTime() - build.getTimestamp().getTime() >= maxDaysToKepp }
	for (build in builds) {
		println "${build}"
		println "Marking to be removed..."
		build.keepLog(false)
	}
}