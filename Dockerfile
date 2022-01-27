FROM openjdk:8
COPY ./target/todoapp-0.0.1-SNAPSHOT.jar spring-boot.jar
COPY wait-for-couchbase-to-complete-setup.sh /opt/wait-for-couchbase-to-complete-setup.sh
RUN chmod +x /opt/wait-for-couchbase-to-complete-setup.sh
CMD ["/opt/wait-for-couchbase-to-complete-setup.sh"]
ENTRYPOINT ["/bin/sh","-c","/opt/wait-for-couchbase-to-complete-setup.sh"]
