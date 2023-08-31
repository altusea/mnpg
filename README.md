# mnpg

> Micronaut playground

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    docker pull postgres:15.4
    docker run --name pg15d4 -e POSTGRES_PASSWORD=whatever -p 5432:5432 -d postgres:15.4
    ```

