# SimpleStore

[![CI](https://github.com/xpian94/simplestore/actions/workflows/github-actions.yml/badge.svg)](https://github.com/xpian94/simplestore/actions/workflows/github-actions.yml)
[![codecov - branches](https://github.com/xpian94/simplestore/blob/main/.github/badges/branches.svg)](https://github.com/xpian94/simplestore/actions/workflows/github-actions.yml)
[![codecov - missed instructions](https://github.com/xpian94/simplestore/blob/main/.github/badges/jacoco.svg)](https://github.com/xpian94/simplestore/actions/workflows/github-actions.yml)

Your on-line store.

## About Tests

- Unit Test : `*Test`
- Integration Test : `*IT`
- End-to-End Test : `*E2ETest`

## Run All Tests

```sh
mvn clean verify -P all-tests
```

### Run Only Unit Tests

```sh
mvn clean verify -DskipITs
```

### Run Only Integration Tests

```sh
mvn clean verify -DskipTests
```

### Run Unit Test and Integration Test

```sh
mvn clean verify
```
