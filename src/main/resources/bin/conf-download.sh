#!/bin/sh
/opt/solr/bin/solr zk -downconfig -z 172.17.194.150:2181/solr -n weshop -d  conf-template-download
