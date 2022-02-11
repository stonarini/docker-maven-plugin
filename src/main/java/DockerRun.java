import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "run", defaultPhase = LifecyclePhase.PACKAGE)
public class DockerRun extends DockerCommand {
	String command = "docker run -t ";

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		runCommand(command + getContainerName());
	}
}