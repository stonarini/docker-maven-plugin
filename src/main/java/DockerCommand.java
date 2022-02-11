import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

public abstract class DockerCommand extends AbstractMojo {

	@Parameter(property = "containerName")
	String containerName;

	public String getContainerName() {
		return this.containerName;
	}

	public void runCommand(String command) throws MojoExecutionException, MojoFailureException {

		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		try {
			Process process = processBuilder.start();

			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = stdoutReader.readLine()) != null) {
				System.out.println(line);
			}

			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((line = stderrReader.readLine()) != null) {
				System.out.println(line);
			}

			process.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
