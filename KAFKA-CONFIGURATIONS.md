### To create a topic

```bash
docker exec -it kafka kafka-topics --create \
  --topic snack-order\
  --bootstrap-server kafka:9092 \
  --partitions 3 \
  --replication-factor 1
```

### To list topics

```bash
docker exec -it kafka kafka-topics --list --bootstrap-server kafka:9092
```
