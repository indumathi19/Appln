<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>
<h1>login successfully</h1>
        <form method="post" action="UploadDownloadFileServlet" enctype="multipart/form-data">
            Select file to upload:
            <input type="file" name="fileName" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form>
</body>
</html>