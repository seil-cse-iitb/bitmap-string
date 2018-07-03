# Start from Apache Ignite image.',
FROM apacheignite/ignite:2.5.0

# Set config uri for node.
ENV CONFIG_URI BitmapClusterString-server.xml

# Copy optional libs.
ENV OPTION_LIBS ignite-rest-http

# Update packages and install maven.
RUN set -x \
    && apk add --no-cache \
        openjdk8

RUN apk --update add \
    maven \
    && rm -rfv /var/cache/apk/*

# Append project to container.
ADD . BitmapClusterString

# Build project in container.
RUN mvn -f BitmapClusterString/pom.xml clean package -DskipTests

# Copy project jars to node classpath.
RUN mkdir $IGNITE_HOME/libs/BitmapClusterString && \
   find BitmapClusterString/target -name "*.jar" -type f -exec cp {} $IGNITE_HOME/libs/BitmapClusterString \;