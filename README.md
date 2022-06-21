# Quarkus Inifinispan Smallrye Metrics Reproducer

A reproducer for `ChainBuildException` exception when `quarkus-infinispan-embedded` and `quarkus-micrometer-registry-prometheus` are used together.

Used in issue [https://github.com/quarkusio/quarkus/discussions/26263](https://github.com/quarkusio/quarkus/discussions/26263).

## Steps to reproduce

Just run the application to reproduce the issue.

```
$ mvn quarkus:dev
```

## Exception stacktrace

```log
ERROR [io.qua.dep.dev.IsolatedDevModeMain] (main) Failed to start quarkus: java.lang.RuntimeException: io.quarkus.builder.ChainBuildException: Multiple producers of item class io.quarkus.deployment.metrics.MetricsCapabilityBuildItem (io.quarkus.smallrye.metrics.deployment.SmallRyeMetricsProcessor#metricsCapabilityBuildItem)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:330)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:252)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:60)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.firstStart(IsolatedDevModeMain.java:95)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:485)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:68)
        at io.quarkus.bootstrap.app.CuratedApplication.runInCl(CuratedApplication.java:142)
        at io.quarkus.bootstrap.app.CuratedApplication.runInAugmentClassLoader(CuratedApplication.java:97)
        at io.quarkus.deployment.dev.DevModeMain.start(DevModeMain.java:132)
        at io.quarkus.deployment.dev.DevModeMain.main(DevModeMain.java:62)
Caused by: io.quarkus.builder.ChainBuildException: Multiple producers of item class io.quarkus.deployment.metrics.MetricsCapabilityBuildItem (io.quarkus.smallrye.metrics.deployment.SmallRyeMetricsProcessor#metricsCapabilityBuildItem)
Caused by: java.lang.Throwable: This is the location of the conflicting producer (io.quarkus.micrometer.deployment.MicrometerProcessor#metricsCapabilityPrometheusBuildItem). Use -Dquarkus.builder.log-conflict-cause=true to see the full stacktrace.
```
