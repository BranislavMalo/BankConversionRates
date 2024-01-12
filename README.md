# BankConversionRates

This project is a Spring Boot application for handling currency conversion rates.

## Prerequisites

- Java 17 or later
- Maven
- Docker

## Dockerize the Application

###Build the Docker Image

Make sure you are in the project's root directory.

```bash
docker build -t bank-conversion-rates:latest .
```

```bash
docker run -p 8080:8080 bank-conversion-rates:latest
```

The application will be accessible at http://localhost:8080.

## Running in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click on `File` -> `Open` and select the project folder.
3. Wait for IntelliJ to import the project.
4. Navigate to BankConversionRatesApplication class in `src/main/java/org/bank/conversion/rates`.
5. Right-click on the class and choose `BankConversionRatesApplication`.

## Running via Script

1. Open a terminal.
2. Navigate to the `BankConversionRates` directory in your project.
   ```bash
   cd /path/to/BankConversionRates
   ```
3. Parameter -p stands for path to the project
   ```bash
   ./start_bcr.sh -p <path/to/BankConversionRates>
   ```

   example: ./start_bcr.sh -p /home/branislavmalo

## Endpoints

### Endpoint 1: Show Actual Rates

Retrieves the actual conversion rates.

```bash
curl --location --request GET 'http://localhost:8080/actual-rates/show-rates'
```

### Endpoint 2: Currency Conversion

Converts an amount from one currency to another.

```bash
curl --location --request POST 'http://localhost:8080/rate-conversion/convert' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 100.0,
    "sourceCurrency": "USD",
    "targetCurrency": "EUR"
}'
```