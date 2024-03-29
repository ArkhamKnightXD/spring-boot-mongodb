
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
            <strong>Crear nueva orden</strong>
        </h1>

        <br>
    </section>


    <form method="post" class="form-horizontal" action="/orden-compra/crear/">
        <div class="row">

            <div class="form-group">
                <label for="fechaOrden" class="control-label col-md-3">Fecha de la orden:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="date" name="fechaOrden" class="form-control" required placeholder="Fecha de la orden...">
                </div>

            </div>



            <div class="form-group">
                <label for="idSuplidor" class="control-label col-md-3">Seleccione el suplidor:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select name="idSuplidor" class="form-control" id="idSuplidor">
                        <#list suplidores as suplidor >
                            <option value="${suplidor.id}">${suplidor.nombre} - Fecha de entrega: ${suplidor.tiempoEntrega?date} </option>
                        </#list>
                    </select>
                </div>

            </div>


            <div class="form-group">
                <label for="idComponentes" class="control-label col-md-3">Seleccione los componentes que desee:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select multiple class="form-control" required name="idComponentes">
                        <#list componentes as componente>
                            <#if componente.stock gt 0>
                                <option value="${componente.id}" class="equipo-option"  >${componente.descripcion} (${componente.stock}) - $${componente.precioUnidadCompra}</option>
                            </#if>
                        </#list>
                    </select>
                </div>


            </div>






            <div class="form-group">
                <button class="btn btn-primary col-md-offset-5" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/orden-compra/" role="button">Cancelar</a>
            </div>


        </div>


    </form>


</div>

</body>
</html>

