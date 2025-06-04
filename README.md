# bbog-cat-serenity-testing-template

This is a template for testing Serenity BDD with Cucumber and JUnit.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Java 17
Maven
```

### Installing and Running

Using Maven Wrapper:

Install

```
# In Mac/Linux
./mvnw clean install

# In Windows
.\mvnw.cmd clean install
```

And run tests

```
# In Mac/Linux
./mvnw clean verify

# In Windows
.\mvnw.cmd clean verify
```

### Update drivers
Open a terminal (Bash or Powershell) with admin permissions

Run the script
```
# In Mac/Linux
./scripts/update-driver.sh

# In Windows
.\scripts\update-driver.ps1
```

### Environment variables

To run in Browserstack:

```
export BROWSERSTACK_KEY="value"
export BROWSERSTACK_USER="value"
```

To install with Jfrog BdB:

```
export ARTIFACTORY_READER_USER="value"
export ARTIFACTORY_READER_API_KEY="value"
```
