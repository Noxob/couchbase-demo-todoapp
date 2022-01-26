set -m

/entrypoint.sh couchbase-server &
echo "waiting for http://couchbase:8091/ui/index.html"
sleep 20

echo "setup index and memory quota"
curl -v -X POST http://couchbase:8091/pools/default -d memoryQuota=512 -d indexMemoryQuota=512
echo "setup services"
curl -v http://couchbase:8091/node/controller/setupServices -d services=kv%2cn1ql%2Cindex
echo "setup index and memory quota"
curl -v http://couchbase:8091/settings/web -d port=8091 -d username=$COUCHBASE_ADMINISTRATOR_USERNAME -d password=$COUCHBASE_ADMINISTRATOR_PASSWORD
curl -i -u $COUCHBASE_ADMINISTRATOR_USERNAME:$COUCHBASE_ADMINISTRATOR_PASSWORD -X POST http://couchbase:8091/settings/indexes -d 'storageMode=memory_optimized'
curl -v -u $COUCHBASE_ADMINISTRATOR_USERNAME:$COUCHBASE_ADMINISTRATOR_PASSWORD -X POST http://couchbase:8091/pools/default/buckets -d name=$COUCHBASE_BUCKET -d bucketType=couchbase -d ramQuotaMB=128 -d authType=sasl -d saslPassword=$COUCHBASE_BUCKET_PASSWORD
sleep 30
curl -v http://couchbase:8093/query/service -d "statement=CREATE PRIMARY INDEX ON `$COUCHBASE_BUCKET`"
fg 1