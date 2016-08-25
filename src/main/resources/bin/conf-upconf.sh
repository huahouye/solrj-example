#!/bin/sh
/opt/solr/bin/solr zk -upconfig -z 172.17.194.150:2181/solr -n weshop -d  conf-template
/opt/solr/bin/solr create -c weshop -n weshop -shards 1 -replicationFactor 2 -p 8983
curl http://localhost:8983/solr/weshop/dataimport?command=full-import

