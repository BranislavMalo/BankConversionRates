#!/bin/bash

# Set the path to your JAR file
JAR_FILE="path/to/your/BankConversionRates-0.0.1-SNAPSHOT.jar"

# Check if the JAR file exists
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: JAR file not found at $JAR_FILE"
    exit 1
fi

# Run the Spring Boot application
java -jar "$JAR_FILE"
