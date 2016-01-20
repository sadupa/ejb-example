This is a java example code using ejb+jsf+maven


How to create a queue in Jboss server
============================================

jboss 6
-------

Add following code to <jboss path>/server/<profile>/deploy/hornetq/hornetq-jms.xml

<queue name="BookQueue">
    <entry name="/queue/BookQueue"/>
</queue>

jboss 5
-------
<jboss path>/server/<profile>/deploy/jbossmq-destinations-service.xml

<mbean code="org.jboss.mq.server.jmx.Queue"
   name="jboss.mq.destination:service=Queue,name=BookQueue">
   <depends optional-attribute-name="DestinationManager">
      jboss.mq:service=DestinationManager
   </depends>
</mbean>
