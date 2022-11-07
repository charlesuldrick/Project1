<%-- 
    Document   : index
    Created on : Nov 6, 2022, 9:09:02 PM
    Author     : chu19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Lab #4</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="script.js"></script>
    <script type="text/javascript" src="jquery-3.6.1.min.js"></script>
</head>

<body>

    <form name="calculatorform" id="calculatorform">

        <fieldset>

            <legend>Currency Conversion Calculator</legend>

            <p>Convert to: 
                <%= Menu.getCurrencyListAsHTML() %>

            <p>
                <label for="usd_value">Value (in USD):</label>
                <input type="number" name="usd_value" id="usd_value">

                <label for="rate_date">Date:</label>
                <input type="date" name="rate_date" id="rate_date">
                
                <label for="access_key">Access Key:</label>
                <input type="text" name="access_key" id="access_key">
            </p>

            <p><input type="button" value="Convert" onclick="Lab4.onClick();"></p>

        </fieldset>

    </form>

    <div id="output"></div>

</body>

</html>