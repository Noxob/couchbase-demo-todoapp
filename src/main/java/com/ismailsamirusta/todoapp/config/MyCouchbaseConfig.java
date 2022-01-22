package com.ismailsamirusta.todoapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages={"com.ismailsamirusta.todoapp"})
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	public String getConnectionString() {
		return "localhost";
	}

	@Override
	public String getUserName() {
		return "Administrator";
	}

	@Override
	public String getPassword() {
		return "******";
	}

	@Override
	public String getBucketName() {
		return "todobucket";
	}
}
