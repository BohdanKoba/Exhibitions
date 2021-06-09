<%@ page contentType="text/html;charset=UTF-8" %>

<style>
    .table table, td {
        border: 1px solid black;
        padding: 10px 20px;
    }
    .table table {
        border: none;
        border-spacing: 0px 10px;
    }
    .table td {
        text-align: center;
        vertical-align: middle;
    }

    .navbar {
        background-color: white;
        text-align: center;
        height: 50px;
        color: black;
    }

    .navbar button {
        width: 200px;
        height:50px;
        vertical-align: top;
        border: none;
        display: inline;
        background: none;
        text-transform: uppercase;
        font-weight: 700;
        color: black;
        letter-spacing: 1px;
        font-size: inherit;
        transition: all 0.3s;
        outline: none;
    }

    .navbar button:hover {
        color: white;
        background: black;
    }

    #tableCenter {
        width:70%;
        margin-left:15%;
        margin-right:15%;
    }

    .header-panel {
        display: flex;
        justify-content: flex-end;
    }

    .footer {
        position: relative;
        bottom: 0;
        width: 100%;
        height: 60px;
    }

    .center {
        text-align: center;
    }

    .form-style {
        background: ivory;
        padding: 30px;
        margin: 50px auto;
        box-shadow: 1px 1px 5px grey;
        border-radius: 10px;
        border: 2px solid black;
    }

    #signIn {
        text-align: center;
        max-width: 200px;
    }

    #register {
        text-align: center;
        max-width: 200px;
    }

    #addExhibition {
        margin: auto;
        max-width: 775px;
    }

    #titleInput {
        width: 400px;
        height: 100px;
        resize: none;
    }

    #descriptionInput {
        width: 675px;
        height: 275px;
        resize: none;
    }

    .linkButton {
        text-decoration: none;
        color: black;
    }
</style>
