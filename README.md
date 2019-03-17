# ThreadSafeRingBuffer

### Running and Deploying web archive
You can use IDE or command line
First u need to run clean and install maven commands
```
mvn clean install
```
war is running on tomcat in embded mode, to run - use romcat plugin
```
tomcat7:run-war:
```
### URL for buffer state request
```
http://localhost:8080/thread-safe-ring-buffer/services/elements/get
```
