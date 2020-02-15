# stw300cem-final-assignment-sadina-jarga-magar
stw300cem-final-assignment-sadina-jarga-magar created by GitHub Classroom
# E-Cosmetics
# Introduction
E-Cosmetics is a skincare treatment application which helps you to grow your cosmetics business efficiently and profitably. 
E-commerce application that refers to the buying of products online that reduces human effort and time. 
Today’s world is dominated by Information and technology, people spent most of the time in Internet. 
People prefer to buy online instead of going to each individual shop.
They can eliminate travel time and cost. They can get their skin problem solution from anywhere.
Also, Application can remains open all the time 24/7.So MyE-Cosmetics is android application that simplifies shopping and 
reduces human effort and time. Among different type of E-commerce, MyE-Cosmetics is (Business to customer).
# Dependencies
### implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.android.support:wear:28.0.0'
    implementation 'com.google.android.gms:play-services-maps:17.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
    implementation 'de.hdodenhof:circleimageview:3.0.1'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.google.code.gson:gson:2.8.5'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    compileOnly 'com.google.android.wearable:wearable:2.4.0'
    implementation 'com.cepheuen.elegant-number-button:lib:1.0.2'
    
# Aims
### To sell best products as per customer needs and demands.
    • To saves user time.
    • To make application more user friendly.
# Objectives
### 	To learn about project planning.

	To learn and implement the skill sets.

	To broaden the scope of my knowledge.

	To learn about usability.

	To study the market of the application.

	To learn about different ethical, social and legal consideration that may arise 	during and post development. 

	To assure secure registration and login.

	To allow receive the skin product according to the skin types and skin problem.

	To design the interface for database manipulation.

	To access the skincare treatment information.

# Features
### User Registration, login
   • Vibration if wrong username or password is entered.
   • Viewing all items
   • Search product based on product name
    •Clear all the details of registration if device is shake.
   • Adding items to cart
   • proceed items to delivery.
   • Google maps
   • Token for authorization.
   • Logout
# Youtube link
# Backened API link
# Rest Client
### Retrofit
Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization. Typically for JSON you use GSon, but you can add custom converters to process XML or other protocols. Retrofit uses the OkHttp library for HTTP requests.Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization. Typically for JSON you use GSon, but you can add custom converters to process XML or other protocols. Retrofit uses the OkHttp library for HTTP requests.

# Call
An invocation of a Retrofit method that sends a request to a webserver and returns a response. Each call yields its own HTTP request and response pair. Use clone() to make multiple calls with the same parameters to the same webserver; this may be used to implement polling or to retry a failed call. Calls may be executed synchronously with execute(), or asynchronously with enqueue(retrofit2.Callback). In either case the call can be canceled at any time with cancel(). A call that is busy writing its request or reading its response may receive a IOException; this is working as designed.

# POST
For a POST request, to add form parameters/values, the getParams() method needs to be overridden and a Map needs to be returned.

# GET
Making GET Requests is simple. The example below uses JsonObjectRequest. It prepares a JsonObjectRequest and passes and then adds it to RequestQueue. The JsonObject accepts 4 parameters (Http method, Url, Json values, Response Listener – Invoked on success, Error Listener – Invoked on failure).
# PUT
For PUT request, we need to pass id. It helps to update the data.
# DELETE
For DELETE request, we need to pass id, it helps to delete the data.
# Conclusion
With the use of this E-Cosmetics application, user can do shopping with one click which simplifies the shopping experience and can search their product what they want.Also, can remove the product from the cart if they want. The product is not delivered until it is finalized by the user from My Cart option. This simplifies the shopping experience for the user.




