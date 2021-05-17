def jobFullName = "FOO/BAR"
def buildNumber = 1
Jenkins.instance.getItemByFullName(jobFullName)
		.getBuildByNumber(buildNumber)
		.finish(
				hudson.model.Result.ABORTED,
				new java.io.IOException("Aborting build")
		);