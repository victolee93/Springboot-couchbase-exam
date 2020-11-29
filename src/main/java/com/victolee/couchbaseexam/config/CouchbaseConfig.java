package com.victolee.couchbaseexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages={"com.victolee.couchbaseexam"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getBucketName() {
        return "sample_bucket";
    }

    @Override
    public String getUserName() {
        return "victolee";
    }

    @Override
    public String getPassword() {
        return "123456";
    }
}
