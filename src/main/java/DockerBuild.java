import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "build", defaultPhase = LifecyclePhase.PACKAGE)
public class DockerBuild extends DockerCommand {
	String command = "docker build -t ";

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		runCommand(command + getContainerName() + " .");
	}
}