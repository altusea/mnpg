package org.example.mnpg.codegen;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

public class JooqCodeGenerator {

    public static void main(String[] args) throws Exception {

        Generate generateConfig = new Generate();
        generateConfig.setPojos(true);

        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql://localhost:5432/postgres")
                        .withUser("postgres")
                        .withPassword("whatever"))
                .withGenerator(new Generator()
                        .withGenerate(generateConfig)
                        .withStrategy(new Strategy().withName("org.example.mnpg.codegen.CustomGeneratorStrategy"))
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.postgres.PostgresDatabase")
                                .withIncludes(".*")
                                .withExcludes("mnpg\\.flyway_schema_history")
                                .withInputSchema("mnpg"))
                        .withTarget(new Target()
                                .withPackageName("org.example.mnpg.db")
                                .withDirectory("target/generated-sources/jooq")));

        GenerationTool.generate(configuration);
    }
}
