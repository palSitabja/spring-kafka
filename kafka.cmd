Run the images:

docker run -p 2181:2181 zookeeper:latest

docker run -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=192.168.0.116:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.0.116:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 bitnami/kafka:latest

docker run -it -p 8080:8080 -e DYNAMIC_CONFIG_ENABLED=true provectuslabs/kafka-ui


Path of kafka inside container:
/opt/bitnami/kafka/bin

Create and describe Topic, Partitions and replications:

kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --create --partitions 3 --replication-factor 1

kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic first_topic --partitions 4

kafka-topics.sh --bootstrap-server localhost:9092 --list

kafka-topics.sh --bootstrap-server localhost:9092 --describe

kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic first_topic

Produce messages:

kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic

Consume messages:

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --from-beginning

Consumer Groups:

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --group my-first-application
##Execute multiple times in different terminal to increase consumers in the group

kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-application

kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --execute --topic first_topic

kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --shift-by -2 --execute --topic first_topic

kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list --state

kafka-consumer-groups.sh --bootstrap-server localhost:9092 --delete --group my-first-application


connect-standalone.sh /opt/bitnami/kafka/config/connect-standalone.properties /opt/bitnami/kafka/connector.properties