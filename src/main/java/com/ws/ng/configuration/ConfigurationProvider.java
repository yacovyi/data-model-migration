package com.ws.ng.configuration;

import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.classpath.ClasspathConfigurationSource;
import org.cfg4j.source.compose.FallbackConfigurationSource;
import org.cfg4j.source.context.environment.ImmutableEnvironment;
import org.cfg4j.source.git.GitConfigurationSourceBuilder;
import org.cfg4j.source.reload.strategy.PeriodicalReloadStrategy;
import org.glassfish.hk2.api.Factory;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Singleton
public class ConfigurationProvider implements Factory<Config> {
    final static String env = System.getProperty("env", "dev");
    final static String branch = System.getProperty("branch", "");
    final static Properties properties = getProperties();
//    String version = getServiceVersion();

    private Config configuration;


    /**
     * Version in pom, without patch version.
     * 1.2.3 -> 1.2
     *
     * @return major.minor version of the service
     */
    private String getServiceVersion() {
        String pomVersion = properties.getProperty("version", "");
        int patchVersionStart = pomVersion.lastIndexOf(".");
        String versionWithoutPatch = pomVersion.substring(0, patchVersionStart);

        return versionWithoutPatch;
    }

    private String serviceName() {
        String artifactId = properties.getProperty("artifactId", "");
        return artifactId;
    }

    private static Properties getProperties() {
        final Properties properties = new Properties();
        try {
            properties.load(ConfigurationProvider.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    String repositoryURI = "https://github.com/dimagoldin/cfg4j-git-sample-config1.git";

    public ConfigurationProvider() {

        ConfigurationSource gitSource = getGitConfigSource();

        ConfigurationSource classPathSource = getClasspathSource();

        ConfigurationSource source = new FallbackConfigurationSource(gitSource, classPathSource);

        // Create configuration provider backed by the source
        org.cfg4j.provider.ConfigurationProvider configurationProvider = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .withEnvironment(new ImmutableEnvironment(branch)) //Indicates the branch from which to take configurations
                .withReloadStrategy(new PeriodicalReloadStrategy(30, TimeUnit.SECONDS))
                .build();

        // Get info about our dog. When you add more friends in the configuration file, object below will automatically reflect that change (by mutating friends() list).
        configuration = configurationProvider.bind("connections", Config.class);

        // Display friends of Reksio!
        System.out.println(configuration.kafkaBrokers());
    }

    private ConfigurationSource getClasspathSource() {
        return new ClasspathConfigurationSource(
                () -> Arrays.asList(Paths.get(
                        "configuration.yaml"))
        );
    }

    private ConfigurationSource getGitConfigSource() {
        return new GitConfigurationSourceBuilder()
                .withRepositoryURI(repositoryURI)
                .withConfigFilesProvider(
                        () -> Arrays.asList(Paths.get(
                                String.format("%s/%s/configuration.yaml", serviceName(), env)
                        ))).build();
    }

    @Override
    public Config provide() {
        return configuration;
    }

    @Override
    public void dispose(Config instance) {

    }
}
