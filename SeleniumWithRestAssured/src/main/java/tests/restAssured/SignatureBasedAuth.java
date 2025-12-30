package tests.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SignatureBasedAuth {
    public static void main(String[] args) throws Exception {
        String secretKey = "mySecretKey123";
        String method = "GET";
        String endpoint = "/api/v1/data";
        String timestamp = String.valueOf(System.currentTimeMillis());

        // Construct the string to sign
        String stringToSign = method + "\n" + endpoint + "\n" + timestamp;

        // Generate signature
        String signature = SignatureUtil.generateSignature(stringToSign, secretKey);

        // Send request with signature headers
        Response response = RestAssured
                .given()
                .baseUri("https://api.example.com")
                .header("X-Timestamp", timestamp)
                .header("X-Signature", signature)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

}

class SignatureUtil {
    public static String generateSignature(String data, String secretKey) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] hash = sha256_HMAC.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
/**
 * Great! Let’s walk through how to implement signature-based authentication in a REST API test using Java + Rest Assured. This is especially useful when testing APIs that require HMAC or custom header-based authentication.
 * ________________________________________
 * 🔧 Step-by-Step: Signature-Based Auth with Rest Assured
 * 1. Generate the Signature (HMAC-SHA256)
 * import javax.crypto.Mac;
 * import javax.crypto.spec.SecretKeySpec;
 * import java.util.Base64;
 *
 * public class SignatureUtil {
 *     public static String generateSignature(String data, String secretKey) throws Exception {
 *         Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
 *         SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
 *         sha256_HMAC.init(secret_key);
 *         byte[] hash = sha256_HMAC.doFinal(data.getBytes());
 *         return Base64.getEncoder().encodeToString(hash);
 *     }
 * }
 * ________________________________________
 * 2. Use Signature in Rest Assured Request
 * import io.restassured.RestAssured;
 * import io.restassured.response.Response;
 *
 * public class SignatureAuthTest {
 *     public static void main(String[] args) throws Exception {
 *         String secretKey = "mySecretKey123";
 *         String method = "GET";
 *         String endpoint = "/api/v1/data";
 *         String timestamp = String.valueOf(System.currentTimeMillis());
 *
 *         // Construct the string to sign
 *         String stringToSign = method + "\n" + endpoint + "\n" + timestamp;
 *
 *         // Generate signature
 *         String signature = SignatureUtil.generateSignature(stringToSign, secretKey);
 *
 *         // Send request with signature headers
 *         Response response = RestAssured
 *             .given()
 *                 .baseUri("https://api.example.com")
 *                 .header("X-Timestamp", timestamp)
 *                 .header("X-Signature", signature)
 *             .when()
 *                 .get(endpoint)
 *             .then()
 *                 .statusCode(200)
 *                 .extract().response();
 *
 *         System.out.println("Response: " + response.asString());
 *     }
 * }
 * ________________________________________
 * 🧠 Notes
 * •	String to sign: Often includes method, path, timestamp, and sometimes body or query params.
 * •	Headers: Custom headers like X-Signature, X-Timestamp, or Authorization are common.
 * •	Replay protection: Timestamp or nonce ensures the request is fresh.
 * Would you like to see a version that includes a POST request with body signing too?
 *
 * 🔁 The Signature Verification Process — Step-by-Step
 * Let’s say you're sending a POST request with a JSON body. You generate a signature using:
 * stringToSign = HTTP_METHOD + "\n" + URL_PATH + "\n" + TIMESTAMP + "\n" + BODY
 * signature = HMAC_SHA256(stringToSign, secretKey)
 * You then send:
 * •	The payload in the body
 * •	The signature in a header (e.g., X-Signature)
 * •	The timestamp in another header (e.g., X-Timestamp)
 * ________________________________________
 * 🧠 So How Does the Server Verify?
 * The server does not trust the signature you sent. Instead, it:
 * 1.	Receives the request with:
 * o	Headers: X-Signature, X-Timestamp
 * o	Body: the actual JSON payload
 * 2.	Reconstructs the same string using:
 * o	The HTTP method (POST)
 * o	The path (/api/v1/data)
 * o	The timestamp from the header
 * o	The raw body (as received)
 * 3.	Generates its own signature using the same secret key:
 * 4.	serverSignature = HMAC_SHA256(stringToSign, secretKey)
 * 5.	Compares the serverSignature with the X-Signature you sent.
 * o	If they match → ✅ request is authentic and untampered
 * o	If they don’t → ❌ reject the request (possible tampering or invalid client)
 * ________________________________________
 * 🔍 Why This Works
 * •	The signature is based on the body, but the body is not modified by the signature itself.
 * •	The server uses the raw body (before parsing) to ensure byte-for-byte integrity.
 * •	The signature is not part of the body, so it doesn’t interfere with the hash.
 * ________________________________________
 * 🧪 Example
 * Client sends:
 * POST /api/v1/data
 * X-Timestamp: 1700000000000
 * X-Signature: abc123...
 *
 * Body:
 * {
 *   "user": "aditya",
 *   "role": "admin"
 * }
 * Server reconstructs:
 * POST
 * /api/v1/data
 * 1700000000000
 * {"user":"aditya","role":"admin"}
 * Then it hashes this with the secret key and compares the result to abc123....
 */