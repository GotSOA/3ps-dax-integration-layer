3ps-dax-integration-layer
=========================

Integration 3PS to DAX using mule by Got SOA?

Deployment to multiple environments
-----------------------------------
Reference: 
http://www.mulesoft.org/documentation/display/current/Deploying+to+Multiple+Environments
http://www.mulesoft.org/documentation/display/current/Using+Parameters+in+Your+Configuration+Files

This configuration helps in deploying in multiple environments such as dev/qa/staging/prod with ease. The properties that needs to be overridden are written in a property file and its location is configured in mule-app.properties. This location can also be defined as JVM parameter. 

app.properties.override.location=path_to_3ps-dax-int-override.properties
