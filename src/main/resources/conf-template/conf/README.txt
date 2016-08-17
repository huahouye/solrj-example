这是一个 solr 用于创建 collection 的配置模板。
需要注意以下几点：
1、需要准备好相关的 jar 包，上传到每台要用到的 solr 服务器的 /opt/solr/application/lib 目录下.
2、修改 data-config.xml.
3、修改 managed-schema.
4、不要上传 schema.xml，都使用 managed-schema 来配置.