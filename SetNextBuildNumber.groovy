def jobFullName = "FOO/BAR"
Jenkins.instance.getItemByFullName(jobFullName).updateNextBuildNumber(1)
