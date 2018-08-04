<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
  box-sizing: border-box;
}
.menu {
  float:left;
  width:60%;
  text-align:center;
}
.menu a {
  background-color:#e5e5e5;
  padding:8px;
  margin-top:7px;
  display:block;
  width:100%;
  color:black;
}
.main {
  float:center;
  width:60%;
  padding:0 20px;
}
.right {
  background-color:#e5e5e5;
  float:left;
  width:20%;
  padding:15px;
  margin-top:7px;
  text-align:center;
}

@media only screen and (max-width:620px) {
  /* For mobile phones: */
  .menu, .main, .right {
    width:100%;
  }
.ui-responsive td, .ui-responsive th {
    width: 100%;
    text-align: left;
    float: left;
	padding-bottom:10px;
}
 .main_test td{
 padding-bottom:0px;
 }
}
</style>
</head>
<body style="font-family:Verdana;overflow-x:auto;" >

<div style="background-color:#e5e5e5;padding:15px;text-align:left;">
  <h1>Micro Services Auto Generation</h1>
</div>

<div style="tabs">
  <div class="tabs">
    <a href="#">New Project Generation</a>
    <a href="#">Update Exisitng Project Details</a>
    <a href="#">About Us</a>
    <a href="#">Timeline</a>
  </div>
<br><br>
<form name="autoGenForm"  action="/microService/autoGen">
  <div class="main" style="border-style: inset;">
    <h2>Project Details</h2>
	     <table data-role="table" class="ui-responsive">
		  <tr>
		    <td>Project name:</td>
			<td><input type="text" name="projectName"/> </td>
		  </tr>
		  <tr>
		    <td>Project package name:</td>
			<td><input type="text" name="package" /></td>
		  </tr>
		  <tr>
		    <td>Project buildTool name:</td>
			<td><input type="text" name="buildTool" value="Maven" readonly /></td>
		  </tr>
		  <tr>
		    <td>Project buildFile Type</td>
			<td><input type="text" name="buildFile" value="JAR" /></td>
		  </tr>
		  <tr>
		    <td></td>
			<td><input type="submit" value="next" /></td>
		  </tr>
		 </table>
		   
		  <br><br>
		  
		  <p>Note: It will generate microService application in executable state with mainApplication, config with maven configuaration.</p>
		  <br>
  </div>
<br><br>
  <div class="main modules" style="border-style: inset;">
    <h2>Project module details</h2>
	      <table data-role="table" class="ui-responsive main_test">
		
		  <tr>
		    <td>Field name<br/><br/><input type="text" name="fieldName" /><br/><br/></td>
			<td>Field Type<br/><br/><input type="text" name="fieldType" /><br/><br/></td>
			<td>Primary/Required<br/><br/><input type="checkbox" name="requiredFirld"  /><br/><br/></td>
			<td><br/><span name="addField"><u>Add</u></span> / <span name="removeField"><u>Remove</u></span></td>
		  </tr>
		  </table>	
		  <br>
		  <br>
		  <h4>Module Integration Details</h4>
		  <table>
		  <tr>
		    <td>Serialize models Integration:</td>
			<td><input type="checkbox" name="serialize"  /> </td>
		  </tr>
		  <tr>
		    <td>JSON format Integration:</td>
			<td><input type="checkbox" name="serialize" /></td>
		  </tr>
		  <tr>
		    <td></td>
			<td><input type="submit" value="next" /></td>
		  </tr>
		  </table>
		  
		  <br><br>
		  
		  <p>Note: It will generate modules,services with RestAPI services. </p>
		  <br><br>
  </div>
  <br><br>
  <div class="main integration" style="border-style: inset;">
    <h2>Project Integration details</h2>
	     <table>
		  <tr>
		    <td>Swagger Integration:</td>
			<td><input type="checkbox" name="swagger"  /> </td>
		  </tr>
		  <tr>
		    <td>JUnit Integration:</td>
			<td><input type="checkbox" name="junit"  /></td>
		  </tr>
		  <tr>
		    <td>JPA Integration:</td>
			<td><input type="checkbox" name="jpa"  /></td>
		  </tr>
		  <tr>
		    <td>RestTemplate Integration:</td>
			<td><input type="checkbox" name="restTemplate"  /></td>
		  </tr>
		  <tr>
		    <td></td>
			<td><input type="submit" value="next" /></td>
		  </tr>
		  </table>
		  <br><br>
		  <p>Note: It will integrate addons like swagger, junit, JPA, restTemplate to consume thirdParty end points.</p>
		  <br><br>
  </div>
  <br><br>
  <div class="main downloadOptions" style="border-style: inset;">
    <h2>Project Download Options</h2>
	      <table>
		  <tr>
		    <td>Zip Download:</td>
			<td><input type="checkbox" name="zip"  /> </td>
		  </tr>
		  <tr>
		    <td>jar/war Download:</td>
			<td><input type="checkbox" name="buildFile"  /> </td>
		  </tr>
		  <tr>
		    <td>VCS Integration:</td>
			<td><input type="checkbox" name="vcsEnable"  /> </td>
		  </tr>
		  </table>
		   
		  <br>
		  <br>
		  <p>Note: It will integrate addons like swagger, junit, JPA, restTemplate to consume thirdParty end points.</p>
		  <br><br>
  </div>
  <br><br>
  <input name="generate" type="submit" value="Generate" />

</form> 

    

  <div class="about">
    <h2>About</h2>
    <p>Micro Services auto generation application with UI controls will make you easy application generation without complete knowldage of Java programming. We will provide build file, we can directly deploy downloaded jar file into web server without any modifications.</p>
  </div>
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</div>
<!-- 
<div class="footer" style="background-color:#e5e5e5;text-align:center;padding:10px;margin-top:7px;">© copyright www.pa1soft.in</div>
-->
</body>

</html>
