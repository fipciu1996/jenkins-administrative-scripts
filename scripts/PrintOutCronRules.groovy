import hudson.model.*
import hudson.triggers.*
TriggerDescriptor TIMER_TRIGGER_DESCRIPTOR = Hudson.instance.getDescriptorOrDie(TimerTrigger.class)

for(item in Jenkins.instance.getAllItems(Job))
{
	def timertrigger = item.getTriggers().get(TIMER_TRIGGER_DESCRIPTOR)
	if (timertrigger) {
		println "${item.getFullName()} | ${timertrigger.spec}"
	}
}