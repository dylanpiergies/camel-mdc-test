# Apache Camel MDC Logging Test Application

This project is for reproducing a possible bug in Camel's MDC logging.

## Building

This project uses the Gradle wrapper. Build using:
```shell
./gradlew build
```
or using the .bat equivalent on Windows:
```shell
gradlew build
```

## JSON Logging

JSON logging is configured in this project, since it makes it easier to inspect objects destined for the log appender.

## Log Output

Log output from [the test](./src/test/java/org/dylanpiergies/camel/mdc/RouteTest.java) can be found in [log_output](./log_output).
