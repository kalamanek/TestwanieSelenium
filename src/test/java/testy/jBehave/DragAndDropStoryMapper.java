
package testy.jBehave;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import testy.jBehave.steps.dragAndDropSteps.DragAndDropSteps;

public class DragAndDropStoryMapper extends JUnitStories{
	

	public DragAndDropStoryMapper(){
		super();
		this.configuredEmbedder()
			.candidateSteps()
			.add(new DragAndDropSteps());
	}
	@Override
	public Configuration configuration(){
		return new MostUsefulConfiguration()
				.useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
				.useStoryReporterBuilder( new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}
	
	@Override
	public List<CandidateSteps> candidateSteps(){
		return new InstanceStepsFactory(configuration(),this)
				.createCandidateSteps();
	}
	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("testy/JBehave/stories/DragAndDrop.story");
	}

}
