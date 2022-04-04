Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { String build ->
	String buildFullName = build.getFullName()
	for (def property : Jenkins.instance.getItemByFullName(buildFullName).properties) {
		if (property.toString().contains("ParametersDefinitionProperty")) {
			for (def parameter : property.value.getParameterDefinitions()) {
				if(parameter.getClass().toString().contains("unochoice")){
					try {
						if(parameter.getScript().getClass().toString().contains("Scriptler")){
							println buildFullName
						}
					} catch (Exception e) {
						println ""
					}
				}
			}
		}
	}
}