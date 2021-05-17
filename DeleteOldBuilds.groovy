def jobFullName = "FOO/BAR"
def firstToRemove = 1
def lastToRemove = 1000
Jenkins.instance.getItemByFullName(jobFullName).builds.findAll {
	it.number > firstToRemove && it.number < lastToRemove
}.each { it.delete() }