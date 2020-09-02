# MobileDeviceSearch
Application Archtecture<br/>
<img src="https://github.com/awaisazeem/MobileDeviceSearch/blob/master/Architecture.PNG" alt="Architecture" style="width:800px;height:600px;"><br/>
Apllication Archtecture uses Spring frame work IOC and Spring boot Rest Controller for all incoming requests<br/>
including it using the spring cache to store the API responses.<br/><br/> 

Application consists of Four Major parts.<br/>
<h1>1 – Front controller</h1><br/>
       Front controller is responsible for all incoming requests. Front controller will populate the search criteria values and pass it to service.<br/>
<h1>2-   Mobile Service</h1><br/>
Mobile service is responsible for calling the filter and consume the rest api client for the service.<br/>
<h1>3 – Filter Service</h1><br/>
Filter service is responsible for filtering based on search criteria based by service to it<br/>
<h1>4 - Client Cache</h1></br/>
It will cache the response of Rest Client as data returned by service is static so subsequent call will be handled by the cache.<br/>

<h1>Technologies Used:  Spring Boot , Java 8 , Maven , Spring Cache</h1><br/>
<h1>How to run</h1><br/>
MobileDeviceSearchApplication.java is the main class. Call below URL after starting the application.<br/>
http://localhost:8081/mobile/search?announceDate=1999&priceEur=200<br/>

<table style="width:100%">
  <tr>
    <th>Method</th>
    <th>EndPoint</th>
  </tr>
  <tr>
    <td>GET</td>
	<td>mobile/search?</td>
</tr>
</table>
<table style="width:100%">
  <tr>
    <th>Valid Query Params</th>
  </tr>
  <tr>
	  <td>id</td>
</tr>
	 <tr>
	  <td>brand</td>
</tr>
	 <tr>
	  <td>phone</td>
</tr>
	 <tr>
	  <td>picture</td>
</tr>
	 <tr>
	  <td>priceEur</td>
</tr>
	 <tr>
	  <td>announceDate</td>
</tr>
	 <tr>
	  <td>sim</td>
</tr>
	 <tr>
	  <td>resolution</td>
</tr>
	 <tr>
	  <td>audioJack</td>
</tr>
	 <tr>
	  <td>gps</td>
</tr>
	 <tr>
	  <td>battery</td>
</tr>
</table>

