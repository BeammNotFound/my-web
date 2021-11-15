FROM java:8

MAINTAINER BeamStark

COPY *.jar /myDemo.jar

CMD ["--server.port= 8080"]

EXPOSE 8080

RUN bash -c 'touch /myDemo.jar'
ENTRYPOINT ["java","-jar","/myDemo.jar"]