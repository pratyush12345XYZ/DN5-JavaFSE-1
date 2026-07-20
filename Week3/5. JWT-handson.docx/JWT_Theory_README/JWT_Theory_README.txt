=========================================================
           Cognizant Digital Nurture (DN) 5.0
         Java FSE Deep Skilling Program - Week 3
             Understanding JWT (Theory Exercise)
=========================================================

Student Details
---------------------------------------------------------
Name       : Pratyush Kumar Mohanty
Roll No.   : 23053320
Email ID   : pratyushmohanty12345@gmail.com

=========================================================
1. What is JWT?
=========================================================

JWT stands for JSON Web Token.

JWT is an Internet standard (RFC 7519) used to securely transmit
information between a client and a server as a JSON object. It is
commonly used for authentication and authorization in RESTful Web
Services.

=========================================================
2. Structure of JWT
=========================================================

A JWT consists of three parts separated by dots (.).

1. Header
   - Contains information about the signing algorithm and token type.

2. Payload
   - Contains application-specific information such as username,
     user role, issued time, and expiry time.

3. Signature
   - Generated using the Header, Payload, and a secret key.
   - Ensures that the token has not been modified.

JWT Format:

Header.Payload.Signature

=========================================================
3. JWT Process Flow
=========================================================

1. Client sends username and password to the server.
2. Server validates the credentials.
3. Server generates a JWT token.
4. Server returns the JWT token to the client.
5. Client stores the JWT token.
6. Client sends the JWT token in the Authorization header as:

   Authorization: Bearer <JWT Token>

7. Server validates the JWT token.
8. If the token is valid, the requested resource is returned.

=========================================================
4. JWT Verification Exercise
=========================================================

Exercise Performed:

1. Opened the Wikipedia page explaining JWT Structure.
2. Opened https://jwt.io/
3. Copied the Header and Payload from the Wikipedia example.
4. Entered the secret key:

   secretkey

5. Verified that the generated JWT token matched the example token
   displayed on the Wikipedia page.

Observation:

The generated JWT token matched the example provided after entering
the same Header, Payload, and secret key.

=========================================================
5. Basic Authentication Verification
=========================================================

Username:

admin

Password:

pwd

Base64 Encoded Value:

YWRtaW46cHdk

Decoded Value:

admin:pwd

Observation:

Basic Authentication only encodes the username and password using
Base64 encoding. Since Base64 is an encoding technique and not an
encryption technique, anyone can easily decode the credentials.

Therefore, sending username and password with every request is not a
secure approach.

=========================================================
6. Why JWT is Better than Basic Authentication
=========================================================

Basic Authentication:

• Sends username and password with every request.
• Credentials are only Base64 encoded.
• Credentials can be decoded easily.

JWT Authentication:

• Username and password are sent only during login.
• Server generates a signed JWT token.
• Client sends only the JWT token with future requests.
• Password is never transmitted again after authentication.
• The server verifies the JWT before allowing access.

=========================================================
7. Conclusion
=========================================================

JWT provides a secure mechanism for authenticating users in RESTful
Web Services. Instead of repeatedly sending usernames and passwords,
a digitally signed token is exchanged between the client and server.
This improves security, reduces the exposure of user credentials,
and is the preferred authentication mechanism for modern web
applications.

=========================================================
Submitted By
=========================================================

Name      : Pratyush Kumar Mohanty
Roll No.  : 23053320
Email ID  : pratyushmohanty12345@gmail.com

=========================================================
End of README
=========================================================