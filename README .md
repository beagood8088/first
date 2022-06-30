- Using docker
```
docker build --tag=notification-server:latest .
```
```
docker run -p8887:8888 notification-server:latest
```

```
docker inspect message-server
docker stop message-server
docker rm message-server
```