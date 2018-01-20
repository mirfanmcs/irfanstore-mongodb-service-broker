
# irfanstore-mongodb-service-broker

This project uses Spring Cloud - Cloud Foundry Service Broker to implement a MongoDB service. The MongoDB service can be deployed anywhere. I deployed that to AWS.


## Create EC2 instance
Create the EC2 instance with the community AMI "MongoDB 3.4 on Ubuntu". Create instance in public subnet with the public IP enabled for EC2 instance.
Enable the port 27017 in the inbond rules of Security Group attached to the EC2 instance.


## MongoDB setup in EC2
SSH into your EC2 instance and setup the initial Admin user:

```
$ mongo
> use admin
> db.createUser({ user: 'admin', pwd: 'password', roles: [{"role" : "readWriteAnyDatabase","db" : "admin"},{"role" : "userAdminAnyDatabase","db" : "admin"}] });
```

Update your mongod.conf file to enable authorization. For example, add lines like these:

```
security:
  authorization: enabled
```
To find out the mongod.conf file in the EC2 instance run the following command on mongo prompt:

`db.adminCommand('getCmdLineOpts');`


Restart your Mongo service and test that authentication is working as expected:

`mongo --authenticationDatabase "admin" -u "admin" -p "password"`

Refer to the MongoDB docs for more details: https://docs.mongodb.com/manual/tutorial/enable-authentication/


## Deploy the Service Broker to Cloud Foundry

The service broker is configured via environment variables, which are defined in the `manifest.yml` file. Make the necessary changes to the MongoDB config in order to connect to your Mongo instance.

Push the service broker as an app to Cloud Foundry:
`cf push`

Register the service broker using the default username and the password obtained from the previous step:
`cf create-service-broker irfanstore-mongodb admin password http://irfanstore-mongodb-service-broker.local.pcfdev.io`

Enable access to the service broker:
`cf enable-service-access irfanstore-mongodb`

Create a service instance:
`cf create-service irfanstore-mongodb default ostore-mongodb`
