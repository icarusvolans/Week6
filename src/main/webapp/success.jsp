<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Spring MVC textarea</title>
</head>

<body>
<h2>Your email is successfuly sent!!</h2>

<h2>Check your mail : </h2>
<h2>Receiver mail: ${signRequest.id}</h2>
<h2>Subject: ${signRequest.deliverable}</h2>
<h2>Message: ${signRequest.copy}</h2>
</body>
</html>