import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "prune", defaultPhase = LifecyclePhase.CLEAN)
public class DockerPrune extends DockerCommand {
	String command = "docker system prune -f";

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		super.runCommand(command);
	}
}