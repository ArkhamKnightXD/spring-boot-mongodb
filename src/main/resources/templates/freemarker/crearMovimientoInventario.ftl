
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title> ${titulo}</title>

    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="../../style/style.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="../../dist/css/skins/skin-blue.min.css">

</head>
<body background="../../pictures/fondo.png">


<div class="container-form center">

    <section class="content-header">
        <h1 class="text-center">
            <strong>Crear nuevo movimiento de inventario</strong>
        </h1>

        <br>
    </section>


    <form method="post" class="form-horizontal" action="/movimiento-inventario/crear/">
        <div class="row">

            <div class="form-group">
                <label for="tipoMovimiento" class="control-label col-md-3">Tipo de movimiento:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select name="tipoMovimiento" class="form-control" required >
                        <option value="Entrada">Entrada</option>
                        <option value="Salida">Salida</option>
                    </select>

                </div>

            </div>



            <div class="form-group">
                <label for="idComponente" class="control-label col-md-3">Seleccione el componente:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select name="idComponente" class="form-control" id="idComponente">
                        <#list componentes as componente >
                            <option value="${componente.id}">${componente.descripcion} - Stock: ${componente.stock}</option>
                        </#list>
                    </select>
                </div>

            </div>


            <div class="form-group">
                <label for="cantidad" class="control-label col-md-3">Cantidad:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="number" name="cantidad" class="form-control" required placeholder="Cantidad...">
                </div>

            </div>


            <div class="form-group">
                <label for="unidad" class="control-label col-md-3">Unidad:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="unidad" class="form-control" required placeholder="Unidad...">
                </div>

            </div>




            <div class="form-group">
                <button class="btn btn-primary col-md-offset-5" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/movimiento-inventario/" role="button">Cancelar</a>
            </div>


        </div>


    </form>


</div>

</body>
</html>

