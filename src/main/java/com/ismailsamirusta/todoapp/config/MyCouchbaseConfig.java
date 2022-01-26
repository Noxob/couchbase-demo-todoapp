package com.ismailsamirusta.todoapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = { "com.ismailsamirusta.todoapp" })
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Value("${couchbase_host}")
	private String hostname;

	@Value("${couchbase_bucket}")
	private String bucket;

	@Value("${couchbase_admin_password}")
	private String password;

	@Override
	public String getConnectionString() {
		return hostname;
	}

	@Override
	public String getUserName() {
		return "Administrator";
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getBucketName() {
		return bucket;
	}
	
}
