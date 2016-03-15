# pdffiller-java-api-client

## Requirements

* Java 1.7
* Google GSON library version 2.0 or newer

## Installation 

To create complete jar package, clone repo and execute:

```shell
mvn clean package -DskipTests
```

To install the API client library to your local Maven repository, clone this repo and execute:

```shell
mvn install
```

After the client libarary is installed/deployed, you can use it in your Maven project by adding the following to your *pom.xml*:

```xml
<dependency>
  <groupId>com.pdffiller</groupId>
  <artifactId>pdffiller-java-client</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage

#### Create signature request

```java
  // Initialize client
  ApiClient client = new PdfFillerAPIClient
                              .Builder(CLIENT_ID,CLIENT_SECRET)
                              .build();
  // Create signature request and add recipients                             
  SignatureRequest request = new SignatureRequest(client);
  SignatureRequestBody.Recipient recipient = 
        new SignatureRequestBody
        .Recipient("jdoe@pdffiller.com", "John Doe", "Subject", "Message", SignatureRequestBody.Recipient.AccessEnum.FULL);
  List<SignatureRequestBody.Recipient> recipients = new ArrayList<SignatureRequestBody.Recipient>();   
  recipients.add(recipient);
  SignatureRequestBody srb = new SignatureRequestBody(54337257, "sendtoeach", "mortgage closing docs", false, recipients);
  // Get response 
  String jsonResponse = request.createSignatureRequest(srb);
```

#### Fill document template
```java
  // Initialize client
  ApiClient client = new PdfFillerAPIClient
                              .Builder(CLIENT_ID,CLIENT_SECRET)
                              .build();
  FillableTemplate template = new FillableTemplate(client);
  FillableTemplateRequestBody request = new FillableTemplateRequestBody();
  request.addFields("field1", "value1");
  request.addFields("field2", "value2");    
  request.setDocumentId(123456);
  String jsonResponse = template.postFillableTemplate(request);
```


## LICENSE

This software is licensed under following MIT [license](https://github.com/egorelik/pdffiller-java-client/blob/v1/LICENSE)

## Author
Eugene Gorelik (gene@pdffiller.com)



