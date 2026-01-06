package org.example.java.multithreading;

import org.testcontainers.containers.Container;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String imageName = "finos/pylegend:0.10.0";
        String script = "from pylegend.core.tds.pandas_api.frames.pandas_api_tds_frame import PandasApiTdsFrame\n" +
                "from pylegend.core.tds.tds_column import PrimitiveTdsColumn\n" +
                "from pylegend.extensions.tds.pandas_api.frames.pandas_api_table_spec_input_frame import PandasApiTableSpecInputFrame\n" +
                "\n" +
                "columns = [PrimitiveTdsColumn.integer_column(\"col1\"), PrimitiveTdsColumn.string_column(\"col2\")]\n" +
                "frame: PandasApiTdsFrame = PandasApiTableSpecInputFrame([\"test_schema\", \"test_table\"], columns)\n" +
                "\n" +
                "print(frame.to_sql_query())";

        // 2. Start Container
        // We use DockerImageName which is the standard in 1.18.3
        try (GenericContainer<?> container = new GenericContainer<>(DockerImageName.parse(imageName)))
        {
            // Force a pull to ensure we have the latest version
            container.withImagePullPolicy(PullPolicy.alwaysPull());

            // Critical: Keep container running indefinitely using a dummy command
            container.withCommand("tail", "-f", "/dev/null");

            System.out.println("Starting container...");
            container.start();
            System.out.println("container started...");
            // 3. Inject Script (Runtime)
            // Create a temporary file on the host
//            tempScriptPath = Files.createTempFile("pylegend_exec", ".py");
//            Files.write(tempScriptPath, script.getBytes(StandardCharsets.UTF_8));
//
//            // Copy it to the running container
//            // In 1.18.3, MountableFile.forHostPath is the correct way to map files
//            String containerScriptPath = "/tmp/script.py";
//            container.copyFileToContainer(MountableFile.forHostPath(tempScriptPath), containerScriptPath);

            // 4. Execute Script
            System.out.println("Executing script...");

            // Note: ExecResult is a nested class inside Container interface
            Container.ExecResult result = container.execInContainer("python3", "-c", script);

            // 5. Handle Output
            if (result.getExitCode() == 0)
            {
                System.out.println("Exit Code: 0");
                System.out.println("Output: " + result.getStdout());
            }
            else
            {
                System.out.println("Exit Code: " + result.getExitCode());
                System.err.println("DOCKER ERROR: " + result.getStderr());
                throw new RuntimeException("Script execution failed: " + result.getStderr());
            }
        }

    }
}
