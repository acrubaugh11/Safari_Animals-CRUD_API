<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index.css">

</head>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<body>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-light d-flex navbar-css" style="background-color: rgb(240, 224, 190);">
    <a class="navbar-brand pr-5" href="all">Safari Animals</a>

    <div class="d-flex w-75 p-3 ml-5" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto justify-content-between">
            <li class="nav-item">
                <a class="nav-link text-dark" href="all">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-dark" href="about">About</a>
            </li>
            <li class="nav-item">
                <div class="dropdown show">
                    <a class="btn dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Details
                    </a>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="all">Go Home</a>
                    </div>
    </div>
    </li>
    </ul>
    <a href="createForm" class="btn btn-dark ml-auto">Create New Safari Animal</a>
    </div>
</nav>

<div class="spacing"></div>

<div class="row mt-5">
    <div class="detailsl" style="background-image: url('/images/${animal.name}.jpg'), url('/images/new.jpg'); ">
    </div>
    <div class="detailsr">
        <h1 class="pt-5 pb-5">${animal.name?capitalize}</h1>
        <p class="descriptionp">${animal.description?capitalize}</p>
        <a href="/animals/delete/${animalId}" class="btn btn-danger ml-auto mt-5">Delete</a>
        <a href="/animals/update/${animalId}" class="btn btn-dark ml-auto mt-5">Edit</a>
    </div>

</div>


</body>
</html>