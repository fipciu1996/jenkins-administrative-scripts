def jobFullName = "PPM/PERFORMANCE/PPM_PERF_TEST_E2E"

def builds = Jenkins.instance.getItemByFullName(jobFullName).getBuilds().findAll {build -> build.getCause(hudson.model.Cause$UserIdCause) != null }

for (def build : builds){
	println "${build} was started by - ${build.getCause(hudson.model.Cause$UserIdCause).getUserName()}"
	println "============================================================"
}