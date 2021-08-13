def folderName = "YOUR/FOLDER/NAME/"
println hudson.model.Hudson.getInstance().getAllItems(Job.class).findAll { it.getFullName().contains(folderName) }