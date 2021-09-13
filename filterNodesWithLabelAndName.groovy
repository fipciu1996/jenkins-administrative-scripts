int counter = 0
String nodeNameToFilter = ""
String labelToFilter = ""
hudson.model.Hudson.getInstance().getNodes()
		.each {
			node ->
				if (node.getNodeName().contains(nodeNameToFilter)) {
					node.getAssignedLabels().each {
						label ->
							if (label.toString() == labelToFilter) {
								counter++
							}
					}
				}
		}


println "Number of filtered nodes: ${counter}"